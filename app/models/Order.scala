package models
import play.api.libs.json._

case class Order(order_id: Int)

object Order {
  implicit val orderFormat = Json.format[Order]
}



