package models

import play.api.libs.json._

case class Cart(product_id: Long)

object Cart {
  implicit val cartFormat = Json.format[Cart]
}


