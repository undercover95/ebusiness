
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

object cart_view extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Seq[Product],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(products: Seq[Product])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/request/*3.9*/.flash.get("success").map/*3.34*/ { key =>_display_(Seq[Any](format.raw/*3.43*/("""
    """),_display_(/*4.6*/request/*4.13*/.messages(key)),format.raw/*4.27*/("""
""")))}),format.raw/*5.2*/("""

"""),_display_(/*7.2*/main("Koszyk")/*7.16*/ {_display_(Seq[Any](format.raw/*7.18*/("""
    """),format.raw/*8.5*/("""<h3>
        Koszyk
    </h3>

    <table>
        <thead>
            <tr>
                <th>produkt</th>
                <th>cena</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        """),_display_(/*21.10*/for(product <- products) yield /*21.34*/{_display_(Seq[Any](format.raw/*21.35*/("""
            """),format.raw/*22.13*/("""<tr>
                <td>"""),_display_(/*23.22*/product/*23.29*/.name),format.raw/*23.34*/("""</td>
                <td>"""),_display_(/*24.22*/product/*24.29*/.price),format.raw/*24.35*/("""</td>
                <td>
                </td>
            </tr>
        """)))}),format.raw/*28.10*/("""
        """),format.raw/*29.9*/("""</tbody>
    </table>

    <a href=""""),_display_(/*32.15*/controllers/*32.26*/.routes.OrderController.makeOrder),format.raw/*32.59*/("""">Zamów</a>
""")))}),format.raw/*33.2*/("""




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
                  DATE: Sat Jun 02 18:37:40 CEST 2018
                  SOURCE: /home/michal/Desktop/ebiznes/play-products-crud-slick-master/app/views/cart_view.scala.html
                  HASH: 5539f154b7c7653010e9c6a7933abc96c47eb0b2
                  MATRIX: 761->1|920->67|947->69|961->76|994->101|1040->110|1071->116|1086->123|1120->137|1151->139|1179->142|1201->156|1240->158|1271->163|1523->388|1563->412|1602->413|1643->426|1696->452|1712->459|1738->464|1792->491|1808->498|1835->504|1942->580|1978->589|2042->626|2062->637|2116->670|2159->683
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|28->4|28->4|28->4|29->5|31->7|31->7|31->7|32->8|45->21|45->21|45->21|46->22|47->23|47->23|47->23|48->24|48->24|48->24|52->28|53->29|56->32|56->32|56->32|57->33
                  -- GENERATED --
              */
          