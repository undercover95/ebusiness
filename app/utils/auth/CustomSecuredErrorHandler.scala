package utils.auth

import javax.inject.Inject
import com.mohiva.play.silhouette.api.actions.SecuredErrorHandler
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.mvc.RequestHeader
import play.api.mvc.Results._
import play.api.libs.json.Json

import scala.concurrent.Future

/**
 * Custom secured error handler.
 *
 * @param messagesApi The Play messages API.
 */
class CustomSecuredErrorHandler @Inject() (val messagesApi: MessagesApi) extends SecuredErrorHandler with I18nSupport {


  val headers = (
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Host, Connection, Accept, Authorization, Content-Type, X-Requested-With, User-Agent, Referer, Methods"
  )

  /**
   * Called when a user is not authenticated.
   *
   * As defined by RFC 2616, the status code of the response should be 401 Unauthorized.
   *
   * @param request The request header.
   * @return The result to send to the client.
   */
  override def onNotAuthenticated(implicit request: RequestHeader) = {
    Future.successful(Ok(Json.obj("CustomSecuredErrorHandler" -> "401 - Unauthorized")).withHeaders(headers._1,headers._2,headers._3))
  }

  /**
   * Called when a user is authenticated but not authorized.
   *
   * As defined by RFC 2616, the status code of the response should be 403 Forbidden.
   *
   * @param request The request header.
   * @return The result to send to the client.
   */
  override def onNotAuthorized(implicit request: RequestHeader) = {
    Future.successful(Ok(Json.obj("CustomSecuredErrorHandler" -> "403 - access denied")).withHeaders(headers._1,headers._2,headers._3))
  }
}
