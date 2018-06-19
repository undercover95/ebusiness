
package views.html

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.api.mvc.RequestHeader
/*3.2*/import org.webjars.play.WebJarsUtil
/*4.2*/import controllers.AssetsFinder

object home extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[models.User,RequestHeader,Messages,WebJarsUtil,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(user: models.User)(implicit request: RequestHeader, messages: Messages, webJarsUtil: WebJarsUtil, assets: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.1*/("""
"""),_display_(/*8.2*/main(messages("home.title"), Some(user))/*8.42*/ {_display_(Seq[Any](format.raw/*8.44*/("""
    """),format.raw/*9.5*/("""<div class="user col-md-6 col-md-offset-3">
        <div class="row">
            <hr class="col-md-12" />
            <h4 class="col-md-8">"""),_display_(/*12.35*/messages("welcome.signed.in")),format.raw/*12.64*/("""</h4>
            <div class="col-md-4 text-right">
                <img src=""""),_display_(/*14.28*/user/*14.32*/.avatarURL.getOrElse(assets.path("images/silhouette.png"))),format.raw/*14.90*/("""" height="40px" />
            </div>
            <hr class="col-md-12" />
        </div>
        <div class="row data">
            <div class="col-md-12">
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*21.50*/messages("first.name")),format.raw/*21.72*/(""":</strong></p><p class="col-md-6">"""),_display_(/*21.107*/user/*21.111*/.firstName.getOrElse("None")),format.raw/*21.139*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*24.50*/messages("last.name")),format.raw/*24.71*/(""":</strong></p><p class="col-md-6">"""),_display_(/*24.106*/user/*24.110*/.lastName.getOrElse("None")),format.raw/*24.137*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*27.50*/messages("full.name")),format.raw/*27.71*/(""":</strong></p><p class="col-md-6">"""),_display_(/*27.106*/user/*27.110*/.fullName.getOrElse("None")),format.raw/*27.137*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*30.50*/messages("email")),format.raw/*30.67*/(""":</strong></p><p class="col-md-6">"""),_display_(/*30.102*/user/*30.106*/.email.getOrElse("None")),format.raw/*30.130*/("""</p>
                </div>
            </div>
        </div>
    </div>
""")))}))
      }
    }
  }

  def render(user:models.User,request:RequestHeader,messages:Messages,webJarsUtil:WebJarsUtil,assets:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(user)(request,messages,webJarsUtil,assets)

  def f:((models.User) => (RequestHeader,Messages,WebJarsUtil,AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (user) => (request,messages,webJarsUtil,assets) => apply(user)(request,messages,webJarsUtil,assets)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Jun 18 22:28:29 CEST 2018
                  SOURCE: /home/michal/Desktop/ebiznes/play-products-crud-slick-master/app/views/home.scala.html
                  HASH: e8f767850ddf99e9ca3051ffd27fb6e44cf2a72d
                  MATRIX: 28->1|65->32|106->67|149->104|537->138|751->259|778->261|826->301|865->303|896->308|1064->449|1114->478|1220->557|1233->561|1312->619|1579->859|1622->881|1685->916|1699->920|1749->948|1887->1059|1929->1080|1992->1115|2006->1119|2055->1146|2193->1257|2235->1278|2298->1313|2312->1317|2361->1344|2499->1455|2537->1472|2600->1507|2614->1511|2660->1535
                  LINES: 4->1|5->2|6->3|7->4|12->6|17->7|18->8|18->8|18->8|19->9|22->12|22->12|24->14|24->14|24->14|31->21|31->21|31->21|31->21|31->21|34->24|34->24|34->24|34->24|34->24|37->27|37->27|37->27|37->27|37->27|40->30|40->30|40->30|40->30|40->30
                  -- GENERATED --
              */
          