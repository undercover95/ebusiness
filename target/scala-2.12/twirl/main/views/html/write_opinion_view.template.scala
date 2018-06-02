
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

object write_opinion_view extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Product,Form[CreateOpinionForm],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(product: Product, opinion: Form[CreateOpinionForm])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/request/*5.9*/.flash.get("success").map/*5.34*/ { key =>_display_(Seq[Any](format.raw/*5.43*/("""
    """),_display_(/*6.6*/request/*6.13*/.messages(key)),format.raw/*6.27*/("""
""")))}),format.raw/*7.2*/("""

"""),_display_(/*9.2*/main("Dodaj opinie dla produktu")/*9.35*/ {_display_(Seq[Any](format.raw/*9.37*/("""
    """),format.raw/*10.5*/("""<h3>
        Dodaj opinie dla produktu """),_display_(/*11.36*/product/*11.43*/.name),format.raw/*11.48*/(""" """),format.raw/*11.49*/("""("""),_display_(/*11.51*/product/*11.58*/.id),format.raw/*11.61*/(""")
    </h3>
    <hr>

    """),_display_(/*15.6*/form(routes.OpinionController.addOpinion(product.id))/*15.59*/ {_display_(Seq[Any](format.raw/*15.61*/("""
        """),_display_(/*16.10*/inputText(opinion("title"))),format.raw/*16.37*/("""
        """),_display_(/*17.10*/textarea(field = opinion("content"), args = 'rows -> 7, 'cols -> 50, 'maxlength -> 300)),format.raw/*17.97*/("""

        """),_display_(/*19.10*/CSRF/*19.14*/.formField),format.raw/*19.24*/("""

        """),format.raw/*21.9*/("""<div class="buttons">
            <input type="submit" value="Dodaj opinie"/>
        </div>
    """)))}),format.raw/*24.6*/("""
""")))}),format.raw/*25.2*/("""




"""))
      }
    }
  }

  def render(product:Product,opinion:Form[CreateOpinionForm],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(product,opinion)(request)

  def f:((Product,Form[CreateOpinionForm]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (product,opinion) => (request) => apply(product,opinion)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue May 08 11:01:03 CEST 2018
                  SOURCE: /home/michal/Desktop/ebiznes/play-products-crud-slick-master/app/views/write_opinion_view.scala.html
                  HASH: 580155ad18d4cc38de5198657cea18dcc0687dd0
                  MATRIX: 789->1|955->97|999->95|1026->113|1053->115|1067->122|1100->147|1146->156|1177->162|1192->169|1226->183|1257->185|1285->188|1326->221|1365->223|1397->228|1464->268|1480->275|1506->280|1535->281|1564->283|1580->290|1604->293|1657->320|1719->373|1759->375|1796->385|1844->412|1881->422|1989->509|2027->520|2040->524|2071->534|2108->544|2236->642|2268->644
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|29->5|30->6|30->6|30->6|31->7|33->9|33->9|33->9|34->10|35->11|35->11|35->11|35->11|35->11|35->11|35->11|39->15|39->15|39->15|40->16|40->16|41->17|41->17|43->19|43->19|43->19|45->21|48->24|49->25
                  -- GENERATED --
              */
          