package models
import play.api.libs.json._

case class OrderedProduct(order_id: Int, product_id: Long)

object OrderedProduct {
  implicit val orderFormat = Json.format[OrderedProduct]
}





