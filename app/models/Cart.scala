package models

import play.api.libs.json._

case class Cart(product_id: Long, quantity: Int)

object Cart {
  implicit val cartFormat = Json.format[Cart]
}


