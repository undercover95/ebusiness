package controllers

import java.util.UUID

import javax.inject.Inject
import com.mohiva.play.silhouette.api._
import com.mohiva.play.silhouette.api.exceptions.ProviderException
import com.mohiva.play.silhouette.api.repositories.AuthInfoRepository
import com.mohiva.play.silhouette.impl.providers._
import models.services.UserService
import org.webjars.play.WebJarsUtil
import play.api.i18n.{I18nSupport, Messages}
import play.api.mvc._
import utils.auth.DefaultEnv
import play.api.libs.json.Json
import com.mohiva.play.silhouette.api.actions.SecuredRequest
import com.mohiva.play.silhouette.api.{LogoutEvent, Silhouette}
import play.api.libs.json.{JsObject, JsString, Json}
import models.daos.UserDAOImpl

import scala.concurrent.{ExecutionContext, Future}

/**
  * The social auth controller.
  *
  * @param components             The Play controller components.
  * @param silhouette             The Silhouette stack.
  * @param userService            The user service implementation.
  * @param authInfoRepository     The auth info service implementation.
  * @param socialProviderRegistry The social provider registry.
  * @param ex                     The execution context.a
  */
class SocialAuthController @Inject() (
                                       components: ControllerComponents,
                                       silhouette: Silhouette[DefaultEnv],
                                       userService: UserService,
                                       authInfoRepository: AuthInfoRepository,
                                       socialProviderRegistry: SocialProviderRegistry
                                     )(
                                       implicit
                                        ex: ExecutionContext,
                                       webJarsUtil: WebJarsUtil,
                                       assets: AssetsFinder
                                     ) extends AbstractController(components) with I18nSupport with Logger {

  val headers = (
    "Access-Control-Allow-Origin" -> "http://localhost:8000",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Host, Connection, Accept, Authorization, Content-Type, X-Requested-With, User-Agent, Referer, Methods",
    "Access-Control-Allow-Credentials" -> "true"
  )


  /**
    * Authenticates a user against a social provider.
    *
    * @param provider The ID of the provider to authenticate against.
    * @return The result to display.
    */

  def authenticate(provider: String) = Action.async { implicit request: Request[AnyContent] =>

    (socialProviderRegistry.get[SocialProvider](provider) match {
      case Some(p: SocialProvider with CommonSocialProfileBuilder) =>
        p.authenticate().flatMap {
          case Left(result) => Future.successful(result)
          case Right(authInfo) => for {
            profile <- p.retrieveProfile(authInfo)
            user <- userService.save(profile)
            authInfo <- authInfoRepository.save(profile.loginInfo, authInfo)
            authenticator <- silhouette.env.authenticatorService.create(profile.loginInfo)
            value <- silhouette.env.authenticatorService.init(authenticator)
            result <- silhouette.env.authenticatorService.embed(value, Redirect(routes.SocialAuthController.loginResult))
          } yield {
            silhouette.env.eventBus.publish(LoginEvent(user, request))
            result
          }
        }
      case _ => Future.failed(new ProviderException(s"Cannot authenticate with unexpected social provider $provider"))
    }).recover {
      case e: ProviderException =>
        logger.error("Unexpected provider error", e)
        Ok(Json.obj("res" -> false))
    }
  }

  def loginResult() = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    println("zalogowano")
    val userData = request.identity.asInstanceOf[models.User]
    Future.successful(Redirect("http://localhost:8000").withCookies(Cookie("userid", userData.userID.toString)))
  }

  def signOut = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    println("wyloguj")

    val result = Redirect("http://localhost:8000").discardingCookies(DiscardingCookie("userid"))

    silhouette.env.eventBus.publish(LogoutEvent(request.identity, request))
    silhouette.env.authenticatorService.discard(request.authenticator, result)
  }

  def getUserData() = Action.async { implicit request: Request[AnyContent] =>

    //println("get user data")

    request.cookies.get("userid") match {
      case Some(cookie) => {
        val idStr = cookie.value
        //println("idStr", idStr)

        userService.retrieve(UUID.fromString(idStr)).map(userObj => {
          userObj match {
            case Some(userData) => {
              //println(userData)
              Ok(Json.toJson(userData)).withHeaders(headers._1,headers._2,headers._3,headers._4)
            }
            case _ => Ok(Json.toJson("")).withHeaders(headers._1,headers._2,headers._3,headers._4)
          }
        })
      }
      case _ => Future.successful(Ok(Json.toJson("")).withHeaders(headers._1,headers._2,headers._3,headers._4))
    }
  }

}
