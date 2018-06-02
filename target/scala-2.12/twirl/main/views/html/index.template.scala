
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[CreateProductForm],Seq[Category],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(product: Form[CreateProductForm], category: Seq[Category])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/request/*5.9*/.flash.get("success").map/*5.34*/ { key =>_display_(Seq[Any](format.raw/*5.43*/("""
   """),_display_(/*6.5*/request/*6.12*/.messages(key)),format.raw/*6.26*/("""
""")))}),format.raw/*7.2*/("""

"""),_display_(/*9.2*/main("Sklep internetowy")/*9.27*/ {_display_(Seq[Any](format.raw/*9.29*/("""
    """),format.raw/*10.5*/("""<h3>Dodaj produkt</h3>
    """),_display_(/*11.6*/form(routes.ProductController.addProduct())/*11.49*/ {_display_(Seq[Any](format.raw/*11.51*/("""
        """),_display_(/*12.10*/inputText(product("name"))),format.raw/*12.36*/("""
        """),_display_(/*13.10*/inputText(product("description"))),format.raw/*13.43*/("""
        """),_display_(/*14.10*/inputText(product("price"))),format.raw/*14.37*/("""

        """),format.raw/*16.9*/("""<select name="category" id="category">
        """),_display_(/*17.10*/for(cat <- category) yield /*17.30*/ {_display_(Seq[Any](format.raw/*17.32*/("""
            """),format.raw/*18.13*/("""<option value=""""),_display_(/*18.29*/cat/*18.32*/.id),format.raw/*18.35*/("""">"""),_display_(/*18.38*/cat/*18.41*/.name),format.raw/*18.46*/("""</option>
        """)))}),format.raw/*19.10*/("""
        """),format.raw/*20.9*/("""</select>


        """),_display_(/*23.10*/CSRF/*23.14*/.formField),format.raw/*23.24*/("""

        """),format.raw/*25.9*/("""<div class="buttons">
            <input type="submit" value="Dodaj produkt"/>
        </div>
    """)))}),format.raw/*28.6*/("""
""")))}),format.raw/*29.2*/("""
"""))
      }
    }
  }

  def render(product:Form[CreateProductForm],category:Seq[Category],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(product,category)(request)

  def f:((Form[CreateProductForm],Seq[Category]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (product,category) => (request) => apply(product,category)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat May 19 13:08:35 CEST 2018
                  SOURCE: /home/michal/Desktop/ebiznes/play-products-crud-slick-master/app/views/index.scala.html
                  HASH: ae4473f5239323f5f979bae50850c2b0d578d8c6
                  MATRIX: 782->1|955->104|999->102|1026->120|1053->122|1067->129|1100->154|1146->163|1176->168|1191->175|1225->189|1256->191|1284->194|1317->219|1356->221|1388->226|1442->254|1494->297|1534->299|1571->309|1618->335|1655->345|1709->378|1746->388|1794->415|1831->425|1906->473|1942->493|1982->495|2023->508|2066->524|2078->527|2102->530|2132->533|2144->536|2170->541|2220->560|2256->569|2304->590|2317->594|2348->604|2385->614|2514->713|2546->715
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|29->5|30->6|30->6|30->6|31->7|33->9|33->9|33->9|34->10|35->11|35->11|35->11|36->12|36->12|37->13|37->13|38->14|38->14|40->16|41->17|41->17|41->17|42->18|42->18|42->18|42->18|42->18|42->18|42->18|43->19|44->20|47->23|47->23|47->23|49->25|52->28|53->29
                  -- GENERATED --
              */
          