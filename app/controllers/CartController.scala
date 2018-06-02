package controllers

import scala.util.{Success, Failure}
import javax.inject._
import models._
import play.api.mvc._
import play.api.libs.json.Json
import scala.concurrent.{ExecutionContext, Future}

class CartController @Inject()(
                                 productsRepo: ProductRepository,
                                 cartRepo: CartRepository,
                                 cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {


  def getCartProducts(): Seq[Product] = {
    var products: Seq[Product] = Seq[Product]()

    var cartItems = cartRepo.list().onComplete {
      case Success(cartItems) => {
        for (item <- cartItems) {
          productsRepo.getProductObjById(item.product_id).map {
            product =>
              products :+= product
              println("in cart: " + products)
          }
        }
        products
      }
      case Failure(_) => print("fail")
    }
    products
  }

  val headers = (
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Host, Connection, Accept, Authorization, Content-Type, X-Requested-With, User-Agent, Referer, Methods"
  )

  def getCartItems = Action.async { implicit request =>

    /*for {
      firstRes <- cartRepo.list().map { cartItems =>
        val productsIds: Seq[Long] = Seq()

        for(cartItem <- cartItems) {
          productsIds :+ cartItem.product_id
        }

        Ok(Json.obj("seq" -> productsIds))
      }
      secondRes <- firstRes match {
        case res =>
          val products: Seq[Product] = Seq()
          println(res.body)
          /*for(productId <- res.body) {
            productsRepo.getProductObjById(productId).map { productInCart => products :+ productInCart }
          }*/
          Ok(Json.obj("res" -> products)).withHeaders(headers._1, headers._2, headers._3)
      }
    } yield secondRes*/

    cartRepo.list().flatMap{ cartItems =>
      Future {
        var productsIds: List[Long] = List()

        for (cartItem <- cartItems) {
          productsIds = productsIds :+ cartItem.product_id
        }

        println("in database: \t"+productsIds.length)
        productsIds
      }
    }.flatMap { productsIdsSeq =>
      productsRepo.getProductsByIds(productsIdsSeq)
    }.map { products => {
        println("in cart: \t\t"+products.length)
        Ok(Json.obj("res" -> products)).withHeaders(headers._1, headers._2, headers._3)
      }
    }
  }

  def addCartItem = Action.async { implicit request =>
    val productId = request.body.asFormUrlEncoded.get("product_id").repr(0)

    cartRepo.create(Cart(productId.toLong)).map { _ =>
      Ok(Json.obj("res" -> productId)).withHeaders(headers._1, headers._2, headers._3)
    }
  }

  def deleteCartItem(product_id: Long) = Action.async { implicit request =>

    cartRepo.delete(Cart(product_id)).map { _ =>
      // If successful, we simply redirect to the index page.
      Ok(Json.obj("res" -> true))
    }
  }

  }
