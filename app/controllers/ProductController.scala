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

class ProductController @Inject()(
                                   productsRepo: ProductRepository,
                                   categoryRepo: CategoryRepository,
                                   cartRepo: CartRepository,
                                  cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  /**
   * The mapping for the person form.
   */
  val productForm: Form[CreateProductForm] = Form {
    mapping(
      "productName" -> nonEmptyText,
      "productDescription" -> nonEmptyText,
      "productCategory" -> number,
      "productPrice" -> nonEmptyText,
      "productImageUrl" -> nonEmptyText
    )(CreateProductForm.apply)(CreateProductForm.unapply)
  }

  val headers = (
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Host, Connection, Accept, Authorization, Content-Type, X-Requested-With, User-Agent, Referer, Methods"
  )

  def addProduct = Action.async { implicit request =>

    productForm.bindFromRequest.fold(
      // The error function. We return the index page with the error form, which will render the errors.
      // We also wrap the result in a successful future, since this action is synchronous, but we're required to return
      // a future because the person creation function returns a future.
      errorForm => {
        Future.successful(
            Ok(Json.obj("result" -> false)).withHeaders(headers._1,headers._2,headers._3)
        )
      },
      product => {
        productsRepo.create(product.name, product.description, product.category, product.price.toFloat, product.image_url).map { _ =>
          Ok(Json.obj("result" -> true)).withHeaders(headers._1,headers._2,headers._3)
        }
      }
    )
  }


  def getProductDataById(prod_id: Long) = Action.async { implicit request =>
    productsRepo.getProductObjById(prod_id).map { product =>
      Ok(Json.toJson(product)).withHeaders(headers._1,headers._2,headers._3)
    }
  }

  def getProducts(cat_id: Int) = Action.async { implicit request =>
    productsRepo.listByCategory(cat_id).map { products =>
      Ok(Json.toJson(products)).withHeaders(headers._1,headers._2,headers._3)
    }
  }

  def deleteProduct(id: Long) = Action.async { implicit request =>

    productsRepo.delete(id).map { _ =>
      // If successful, we simply redirect to the index page.
      Ok(Json.obj("success" -> true)).withHeaders(headers._1,headers._2,headers._3)
    }
  }

}

case class CreateProductForm(name: String, description: String, category: Int, price: String, image_url: String)


