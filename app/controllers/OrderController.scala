package controllers

import javax.inject._
import models._
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import play.api.libs.json.Json

class OrderController @Inject()(
                                 productsRepo: ProductRepository,
                                 cartRepo: CartRepository,
                                 ordersRepo: OrderRepository,
                                 orderedProductsRepo: OrderedProductRepository,
                                 cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {


  def getOrders = Action.async { implicit request =>

    ordersRepo.list().map { orders =>
      val res = collection.mutable.Map[Order, Seq[Product]]()

      for(order <- orders) {
        orderedProductsRepo.getOrderedProductsForGivenOrder(order.order_id).onComplete {
          orderedProducts =>

            val products: Seq[Product] = Seq.empty
            res(order) = products

            for(orderedProductId <- orderedProducts.get) {
              productsRepo.getProductObjById(orderedProductId.product_id).onComplete{
                product =>
                  //products :+= product.get
                  res(order) :+= product.get
                  println("Order products: "+res(order))
                  Ok(Json.obj("res" -> true))
              }
            }

            println("Products for order id "+order.order_id + " => "+products)
        }
      }
      Ok(Json.obj("res" -> true))
    }
  }

  def makeOrder = Action.async { implicit request =>
    ordersRepo.create(Order(0)).map{ order =>

      // get all items in cart
      /*cartRepo.list().map { items =>
        for(item <- items) {
          orderedProductsRepo.create(OrderedProduct(order.order_id, item.product_id))

          // delete from cart
          cartRepo.delete(item)
        }
      }*/

      Ok(Json.obj("res" -> true))
    }
  }

}
