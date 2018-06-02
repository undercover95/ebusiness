
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object products_view extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Seq[Product],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(products: Seq[Product])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/request/*3.9*/.flash.get("success").map/*3.34*/ { key =>_display_(Seq[Any](format.raw/*3.43*/("""
    """),_display_(/*4.6*/request/*4.13*/.messages(key)),format.raw/*4.27*/("""
""")))}),format.raw/*5.2*/("""

"""),_display_(/*7.2*/main("Widok produktów")/*7.25*/ {_display_(Seq[Any](format.raw/*7.27*/("""
    """),format.raw/*8.5*/("""<h3>
        Widok produktów
    </h3>

    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>nazwa</th>
                <th>opis</th>
                <th>id kategorii</th>
                <th>cena</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        """),_display_(/*24.10*/for(product <- products) yield /*24.34*/{_display_(Seq[Any](format.raw/*24.35*/("""
            """),format.raw/*25.13*/("""<tr>
                <td>"""),_display_(/*26.22*/product/*26.29*/.id),format.raw/*26.32*/("""</td>
                <td>"""),_display_(/*27.22*/product/*27.29*/.name),format.raw/*27.34*/("""</td>
                <td>"""),_display_(/*28.22*/product/*28.29*/.description),format.raw/*28.41*/("""</td>
                <td>"""),_display_(/*29.22*/product/*29.29*/.category),format.raw/*29.38*/("""</td>
                <td>"""),_display_(/*30.22*/product/*30.29*/.price),format.raw/*30.35*/("""</td>
                <td>
                    <a href=""""),_display_(/*32.31*/controllers/*32.42*/.routes.ProductController.deleteProduct(product.id)),format.raw/*32.93*/("""">Usuń</a>
                    <a href=""""),_display_(/*33.31*/controllers/*33.42*/.routes.OpinionController.getOpinions(product.id)),format.raw/*33.91*/("""">Zobacz opinie</a>
                    <a href=""""),_display_(/*34.31*/controllers/*34.42*/.routes.OpinionController.writeOpinion(product.id)),format.raw/*34.92*/("""">Dodaj opinie</a>
                </td>
            </tr>
        """)))}),format.raw/*37.10*/("""
        """),format.raw/*38.9*/("""</tbody>
    </table>
""")))}),format.raw/*40.2*/("""




"""))
      }
    }
  }

  def render(products:Seq[Product],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(products)(request)

  def f:((Seq[Product]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (products) => (request) => apply(products)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Jun 02 18:37:17 CEST 2018
                  SOURCE: /home/michal/Desktop/ebiznes/play-products-crud-slick-master/app/views/products_view.scala.html
                  HASH: 70c718d8b931e5088b6df71be52ddf5a6f5c836b
                  MATRIX: 765->1|924->67|951->69|965->76|998->101|1044->110|1075->116|1090->123|1124->137|1155->139|1183->142|1214->165|1253->167|1284->172|1639->500|1679->524|1718->525|1759->538|1812->564|1828->571|1852->574|1906->601|1922->608|1948->613|2002->640|2018->647|2051->659|2105->686|2121->693|2151->702|2205->729|2221->736|2248->742|2332->799|2352->810|2424->861|2492->902|2512->913|2582->962|2659->1012|2679->1023|2750->1073|2849->1141|2885->1150|2938->1173
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|28->4|28->4|28->4|29->5|31->7|31->7|31->7|32->8|48->24|48->24|48->24|49->25|50->26|50->26|50->26|51->27|51->27|51->27|52->28|52->28|52->28|53->29|53->29|53->29|54->30|54->30|54->30|56->32|56->32|56->32|57->33|57->33|57->33|58->34|58->34|58->34|61->37|62->38|64->40
                  -- GENERATED --
              */
          