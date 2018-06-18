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

class CategoryController @Inject()(
                                    categoryRepo: CategoryRepository,
                                    cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {


  val categoryForm: Form[CreateCategoryForm] = Form {
    mapping(
      "categoryName" -> nonEmptyText
    )(CreateCategoryForm.apply)(CreateCategoryForm.unapply)
  }

  val headers = (
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Host, Connection, Accept, Authorization, Content-Type, X-Requested-With, User-Agent, Referer, Methods"
  )


  def getCategories = Action.async { implicit request =>
    categoryRepo.list().map(categories => Ok(Json.toJson(categories)).withHeaders(headers._1,headers._2,headers._3))
  }

  def getCategoriesWithCounters = Action.async { implicit request =>
    categoryRepo.listWithCounters().map(categories => Ok(Json.toJson(categories)).withHeaders(headers._1,headers._2,headers._3))
  }

  def addCategory = Action.async { implicit request =>

    var a:Seq[Category] = Seq[Category]()
    val categories = categoryRepo.list().onComplete{
      case Success(cat) => a= cat
      case Failure(_) => print("fail")
    }

    categoryForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          Ok(Json.obj("result" -> false)).withHeaders(headers._1,headers._2,headers._3)
        )
      },
      category => {
        categoryRepo.create(category.name).map { _ =>
          Ok(Json.obj("result" -> true)).withHeaders(headers._1,headers._2,headers._3)
        }
      }
    )
  }
}

case class CreateCategoryForm(name: String)