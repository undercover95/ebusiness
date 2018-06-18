package controllers

import javax.inject._
import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class OpinionController @Inject()(
                                   opinionsRepo: OpinionRepository,
                                   productsRepo: ProductRepository,
                                  cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  /**
   * The mapping for the person form.
   */
  val opinionForm: Form[CreateOpinionForm] = Form {
    mapping(
      "opinionTitle" -> nonEmptyText,
      "opinionText" -> nonEmptyText,
      "opinionStarRatio" -> number
    )(CreateOpinionForm.apply)(CreateOpinionForm.unapply)
  }

  val headers = (
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Host, Connection, Accept, Authorization, Content-Type, X-Requested-With, User-Agent, Referer, Methods"
  )

  def addOpinion(product_id: Long) = Action.async { implicit request =>

    print("Dodaje opinie dla produktu", product_id)
    opinionForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          Ok(Json.obj("result" -> false)).withHeaders(headers._1,headers._2,headers._3)
        )
      },
      opinion => {
        opinionsRepo.create(Opinion(product_id, opinion.title, opinion.content, opinion.star_ratio)).map { _ =>
          // If successful, we simply redirect to the index page.
          Ok(Json.obj("result" -> true)).withHeaders(headers._1,headers._2,headers._3)
        }
      }
    )
  }


  def getOpinions(product_id: Long) = Action.async { implicit request =>
    opinionsRepo.list(product_id).map { opinions =>
      Ok(Json.toJson(opinions)).withHeaders(headers._1,headers._2,headers._3)
    }
  }


}

case class CreateOpinionForm(title: String, content: String, star_ratio: Int)