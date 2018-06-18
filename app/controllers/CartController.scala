package controllers

import java.util

import scala.util.{Failure, Success}
import javax.inject._
import models._
import play.api.mvc._
import play.api.libs.json.{JsObject, JsString, Json}

import scala.collection.mutable
import scala.concurrent.{ExecutionContext, Future}
import scala.collection.mutable.HashMap

class CartController @Inject()(
                                 productsRepo: ProductRepository,
                                 cartRepo: CartRepository,
                                 cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  val headers = (
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Host, Connection, Accept, Authorization, Content-Type, X-Requested-With, User-Agent, Referer, Methods"
  )

  def getCartItems = Action.async { implicit request =>

    var counters: HashMap[Long, Int] = HashMap[Long, Int]()

    cartRepo.list().flatMap{ cartItems =>

      for(el <- cartItems) {
        counters += (el.product_id -> el.quantity)
      }

      productsRepo.getProductsByIds(counters.keys.toList)
    }.map { products => {

        var res: List[JsObject] = List[JsObject]()

        for(prod <- products) {
          res :+= (Json.toJson(prod).as[JsObject] + ("quantity" -> JsString(counters.get(prod.id).get.toString)))
        }

        Ok(Json.obj("res" -> res)).withHeaders(headers._1, headers._2, headers._3)
      }
    }
  }

  def addCartItem = Action.async { implicit request =>
    val productId = request.body.asFormUrlEncoded.get("product_id").repr(0)

    cartRepo.create(Cart(productId.toLong, 1)).map { res =>
      println(res)
      Ok(Json.obj("res" -> res)).withHeaders(headers._1, headers._2, headers._3)
    }
  }

  def deleteCartItem() = Action.async { implicit request =>
    val productId = request.body.asFormUrlEncoded.get("product_id").repr(0)
    println("usuwam: " + productId)

    cartRepo.delete(productId.toLong).map { _ =>
      // If successful, we simply redirect to the index page.
      Ok(Json.obj("res" -> true)).withHeaders(headers._1, headers._2, headers._3)
    }
  }

  }
