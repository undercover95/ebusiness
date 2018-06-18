package models

import play.api.libs.json._

case class Product(id: Long, name: String, description: String, category: Int, price: Float, image_url: String)

object Product {
  implicit val productFormat = Json.format[Product]
}
