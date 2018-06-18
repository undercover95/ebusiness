
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

object orders_view extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[collection.mutable.Map[Order, Seq[Product]],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(orders: collection.mutable.Map[Order, Seq[Product]])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/request/*3.9*/.flash.get("success").map/*3.34*/ { key =>_display_(Seq[Any](format.raw/*3.43*/("""
    """),_display_(/*4.6*/request/*4.13*/.messages(key)),format.raw/*4.27*/("""
""")))}),format.raw/*5.2*/("""

"""),_display_(/*7.2*/main("Moje zamówienia")/*7.25*/ {_display_(Seq[Any](format.raw/*7.27*/("""
    """),format.raw/*8.5*/("""<h3>
        Moje zamówienia
    </h3>

    <table>
        <thead>
            <tr>
                <th>id zamówienia</th>
                <th>produkty</th>
                <th>Wartość zamówienia</th>
            </tr>
        </thead>
        <tbody>
        """),_display_(/*21.10*/for(order <- orders.keys) yield /*21.35*/{_display_(Seq[Any](format.raw/*21.36*/("""
            """),format.raw/*22.13*/("""<tr>
                <td>"""),_display_(/*23.22*/order/*23.27*/.order_id),format.raw/*23.36*/("""</td>
                <td>
                    <ul>
                    """),_display_(/*26.22*/for(product <- orders(order)) yield /*26.51*/{_display_(Seq[Any](format.raw/*26.52*/("""
                        """),format.raw/*27.25*/("""<li>"""),_display_(/*27.30*/product/*27.37*/.name),format.raw/*27.42*/(""" """),format.raw/*27.43*/("""("""),_display_(/*27.45*/product/*27.52*/.price),format.raw/*27.58*/(""")</li>
                    """)))}),format.raw/*28.22*/("""
                    """),format.raw/*29.21*/("""</ul>
                </td>
                <td>
                    """),_display_(/*32.22*/{
                        var sum = 0.0
                        for(product <- orders(order)){
                            sum += product.price
                        }
                        "%.2f".format(sum)
                    }),format.raw/*38.22*/("""

                """),format.raw/*40.17*/("""</td>
            </tr>
        """)))}),format.raw/*42.10*/("""
        """),format.raw/*43.9*/("""</tbody>
    </table>
""")))}),format.raw/*45.2*/("""




"""))
      }
    }
  }

  def render(orders:collection.mutable.Map[Order, Seq[Product]],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(orders)(request)

  def f:((collection.mutable.Map[Order, Seq[Product]]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (orders) => (request) => apply(orders)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Jun 02 18:37:17 CEST 2018
                  SOURCE: /home/michal/Desktop/ebiznes/play-products-crud-slick-master/app/views/orders_view.scala.html
                  HASH: 01448d41c531c3bd315d29017a55107698aa006b
                  MATRIX: 794->1|982->96|1009->98|1023->105|1056->130|1102->139|1133->145|1148->152|1182->166|1213->168|1241->171|1272->194|1311->196|1342->201|1631->463|1672->488|1711->489|1752->502|1805->528|1819->533|1849->542|1949->615|1994->644|2033->645|2086->670|2118->675|2134->682|2160->687|2189->688|2218->690|2234->697|2261->703|2320->731|2369->752|2466->822|2721->1056|2767->1074|2831->1107|2867->1116|2920->1139
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|28->4|28->4|28->4|29->5|31->7|31->7|31->7|32->8|45->21|45->21|45->21|46->22|47->23|47->23|47->23|50->26|50->26|50->26|51->27|51->27|51->27|51->27|51->27|51->27|51->27|51->27|52->28|53->29|56->32|62->38|64->40|66->42|67->43|69->45
                  -- GENERATED --
              */
          