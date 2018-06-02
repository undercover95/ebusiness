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
      "title" -> nonEmptyText,
      "content" -> nonEmptyText
    )(CreateOpinionForm.apply)(CreateOpinionForm.unapply)
  }

  def writeOpinion(product_id: Long) = Action.async { implicit request =>
    productsRepo.getProductObjById(product_id).map{ product =>
      Ok(views.html.write_opinion_view(product, opinionForm))
    }
  }

  def addOpinion(product_id: Long) = Action.async { implicit request =>


    opinionForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
            Ok(views.html.write_opinion_view(Product(1, "","",-1, 0.00f),errorForm))
        )
      },
      opinion => {
        opinionsRepo.create(Opinion(product_id, opinion.title, opinion.content)).map { _ =>
          // If successful, we simply redirect to the index page.
          Redirect(routes.OpinionController.writeOpinion(product_id)).flashing("success" -> "dodano opinie")
        }
      }
    )
  }


  def getOpinions(product_id: Long) = Action.async { implicit request =>
    opinionsRepo.list(product_id).map { opinions =>

      productsRepo.getProductObjById(product_id).onComplete{product =>
        val prodName = product.get.name
        Ok(views.html.opinions_view(prodName, opinions))
      }
      Ok(views.html.opinions_view("", opinions))
    }
  }


}

case class CreateOpinionForm(title: String, content: String)