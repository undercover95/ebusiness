
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

object opinions_view extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Seq[Opinion],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(productName: String, opinions: Seq[Opinion])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/request/*3.9*/.flash.get("success").map/*3.34*/ { key =>_display_(Seq[Any](format.raw/*3.43*/("""
    """),_display_(/*4.6*/request/*4.13*/.messages(key)),format.raw/*4.27*/("""
""")))}),format.raw/*5.2*/("""

"""),_display_(/*7.2*/main("Opinie dla produktu")/*7.29*/ {_display_(Seq[Any](format.raw/*7.31*/("""
    """),format.raw/*8.5*/("""<h3>
        Opinie dla produktu """),_display_(/*9.30*/productName),format.raw/*9.41*/("""
    """),format.raw/*10.5*/("""</h3>
    <hr>

    """),_display_(/*13.6*/for(opinion <- opinions) yield /*13.30*/{_display_(Seq[Any](format.raw/*13.31*/("""
        """),format.raw/*14.9*/("""<h4>"""),_display_(/*14.14*/opinion/*14.21*/.title),format.raw/*14.27*/("""</h4>
        <p>"""),_display_(/*15.13*/opinion/*15.20*/.opinion),format.raw/*15.28*/("""</p>
    """)))}),format.raw/*16.6*/("""
""")))}),format.raw/*17.2*/("""




"""))
      }
    }
  }

  def render(productName:String,opinions:Seq[Opinion],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(productName,opinions)(request)

  def f:((String,Seq[Opinion]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (productName,opinions) => (request) => apply(productName,opinions)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue May 08 11:02:19 CEST 2018
                  SOURCE: /home/michal/Desktop/ebiznes/play-products-crud-slick-master/app/views/opinions_view.scala.html
                  HASH: e78f5e94b8629602725f889611a646a274fcb2da
                  MATRIX: 772->1|952->88|979->90|993->97|1026->122|1072->131|1103->137|1118->144|1152->158|1183->160|1211->163|1246->190|1285->192|1316->197|1376->231|1407->242|1439->247|1486->268|1526->292|1565->293|1601->302|1633->307|1649->314|1676->320|1721->338|1737->345|1766->353|1806->363|1838->365
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|28->4|28->4|28->4|29->5|31->7|31->7|31->7|32->8|33->9|33->9|34->10|37->13|37->13|37->13|38->14|38->14|38->14|38->14|39->15|39->15|39->15|40->16|41->17
                  -- GENERATED --
              */
          