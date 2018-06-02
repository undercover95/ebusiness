
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*8.59*/routes/*8.65*/.Assets.versioned("images/favicon.png")),format.raw/*8.104*/(""""/>
    </head>
    <body>
        <nav>
            <ul>
                <li><a href=""""),_display_(/*13.31*/controllers/*13.42*/.routes.OrderController.getOrders()),format.raw/*13.77*/("""">Zamówienia</a></li>
                <li><a href="#">Płatności</a></li>
            </ul>
        </nav>
        """),_display_(/*17.10*/content),format.raw/*17.17*/("""
    """),format.raw/*18.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Jun 02 18:37:17 CEST 2018
                  SOURCE: /home/michal/Desktop/ebiznes/play-products-crud-slick-master/app/views/main.scala.html
                  HASH: bb1bc3d75025341263350eabebb04f94ccea7dba
                  MATRIX: 733->1|857->32|884->33|961->84|986->89|1079->156|1093->162|1153->201|1268->289|1288->300|1344->335|1486->450|1514->457|1546->462
                  LINES: 21->1|26->2|27->3|31->7|31->7|32->8|32->8|32->8|37->13|37->13|37->13|41->17|41->17|42->18
                  -- GENERATED --
              */
          