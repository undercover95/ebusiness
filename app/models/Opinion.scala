package models

import play.api.libs.json._

case class Opinion(product_id: Long, title: String, opinion: String, star_ratio: Int)

object Opinion {
  implicit val opinionFormat = Json.format[Opinion]
}



