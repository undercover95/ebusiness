
package views.html

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.api.mvc.RequestHeader
/*3.2*/import play.twirl.api.Html
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[String,Option[models.User],Html,RequestHeader,Messages,AssetsFinder,WebJarsUtil,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(title: String, user: Option[models.User] = None)(content: Html)(implicit request: RequestHeader, messages: Messages, assets: AssetsFinder, webJarsUtil: WebJarsUtil):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/assets/*15.65*/.path("images/favicon.png")),format.raw/*15.92*/("""">
        <title>"""),_display_(/*16.17*/title),format.raw/*16.22*/("""</title>
        <link href="//fonts.googleapis.com/css?family=Roboto|Montserrat:400,700|Open+Sans:400,300,600" rel="stylesheet">
        <link href="//cdnjs.cloudflare.com/ajax/libs/ionicons/1.5.2/css/ionicons.min.css" rel="stylesheet">
        """),_display_(/*19.10*/Html(webJarsUtil.css("bootstrap.min.css"))),format.raw/*19.52*/("""
        """),_display_(/*20.10*/Html(webJarsUtil.css("bootstrap-theme.min.css"))),format.raw/*20.58*/("""
        """),format.raw/*21.9*/("""<link rel="stylesheet" href=""""),_display_(/*21.39*/assets/*21.45*/.path("styles/main.css")),format.raw/*21.69*/("""">
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
    </head>
    <body>
        <header class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">"""),_display_(/*33.48*/messages("toggle.navigation")),format.raw/*33.77*/("""</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Silhouette Seed Template</a>
                </div>
                <nav class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#">"""),_display_(/*42.42*/messages("home")),format.raw/*42.58*/("""</a></li>
                        <li><a href="https://github.com/mohiva/play-silhouette-seed">GitHub</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                    """),_display_(/*46.22*/user/*46.26*/.map/*46.30*/ { u =>_display_(Seq[Any](format.raw/*46.37*/("""
                    """),format.raw/*47.21*/("""<li><a href="#">"""),_display_(/*47.38*/u/*47.39*/.name),format.raw/*47.44*/("""</a></li>
                    """),_display_(/*48.22*/if(u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID)/*48.116*/ {_display_(Seq[Any](format.raw/*48.118*/("""
                        """),format.raw/*49.25*/("""<li><a href="#">"""),_display_(/*49.42*/messages("change.password")),format.raw/*49.69*/("""</a></li>
                    """)))}),format.raw/*50.22*/("""
                    """),format.raw/*51.21*/("""<li><a href="#">"""),_display_(/*51.38*/messages("sign.out")),format.raw/*51.58*/("""</a></li>
                    """)))}/*52.22*/.getOrElse/*52.32*/ {_display_(Seq[Any](format.raw/*52.34*/("""
                        """),format.raw/*53.25*/("""<li><a href="#">"""),_display_(/*53.42*/messages("sign.in")),format.raw/*53.61*/("""</a></li>
                        <li><a href="#">"""),_display_(/*54.42*/messages("sign.up")),format.raw/*54.61*/("""</a></li>
                    """)))}),format.raw/*55.22*/("""
                    """),format.raw/*56.21*/("""</ul>
                </nav>
            </div>
        </header>
        <main class="container">
            <div class="starter-template row">
                """),_display_(/*62.18*/request/*62.25*/.flash.get("error").map/*62.48*/ { msg =>_display_(Seq[Any](format.raw/*62.57*/("""
                    """),format.raw/*63.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*65.34*/messages("error")),format.raw/*65.51*/("""</strong> """),_display_(/*65.62*/msg),format.raw/*65.65*/("""
                    """),format.raw/*66.21*/("""</div>
                """)))}),format.raw/*67.18*/("""
                """),_display_(/*68.18*/request/*68.25*/.flash.get("info").map/*68.47*/ { msg =>_display_(Seq[Any](format.raw/*68.56*/("""
                    """),format.raw/*69.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*71.34*/messages("info")),format.raw/*71.50*/("""</strong> """),_display_(/*71.61*/msg),format.raw/*71.64*/("""
                    """),format.raw/*72.21*/("""</div>
                """)))}),format.raw/*73.18*/("""
                """),_display_(/*74.18*/request/*74.25*/.flash.get("success").map/*74.50*/ { msg =>_display_(Seq[Any](format.raw/*74.59*/("""
                    """),format.raw/*75.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*77.34*/messages("success")),format.raw/*77.53*/("""</strong> """),_display_(/*77.64*/msg),format.raw/*77.67*/("""
                    """),format.raw/*78.21*/("""</div>
                """)))}),format.raw/*79.18*/("""
                """),_display_(/*80.18*/content),format.raw/*80.25*/("""
            """),format.raw/*81.13*/("""</div>
        </main>
        """),_display_(/*83.10*/Html(webJarsUtil.script("jquery.min.js"))),format.raw/*83.51*/("""
        """),_display_(/*84.10*/Html(webJarsUtil.script("bootstrap.min.js"))),format.raw/*84.54*/("""
        """),format.raw/*85.9*/("""<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
        <script src=""""),_display_(/*86.23*/assets/*86.29*/.path("javascripts/zxcvbnShim.js")),format.raw/*86.63*/(""""></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,user:Option[models.User],content:Html,request:RequestHeader,messages:Messages,assets:AssetsFinder,webJarsUtil:WebJarsUtil): play.twirl.api.HtmlFormat.Appendable = apply(title,user)(content)(request,messages,assets,webJarsUtil)

  def f:((String,Option[models.User]) => (Html) => (RequestHeader,Messages,AssetsFinder,WebJarsUtil) => play.twirl.api.HtmlFormat.Appendable) = (title,user) => (content) => (request,messages,assets,webJarsUtil) => apply(title,user)(content)(request,messages,assets,webJarsUtil)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Jun 18 22:28:29 CEST 2018
                  SOURCE: /home/michal/Desktop/ebiznes/play-products-crud-slick-master/app/views/main.scala.html
                  HASH: 5300f4cfdde943ac3d3f8390bc8e604c3257bab2
                  MATRIX: 28->1|65->32|106->67|140->95|183->132|591->166|850->332|877->333|1176->605|1191->611|1239->638|1285->657|1311->662|1585->909|1648->951|1685->961|1754->1009|1790->1018|1847->1048|1862->1054|1907->1078|2627->1771|2677->1800|3156->2252|3193->2268|3439->2487|3452->2491|3465->2495|3510->2502|3559->2523|3603->2540|3613->2541|3639->2546|3697->2577|3801->2671|3842->2673|3895->2698|3939->2715|3987->2742|4049->2773|4098->2794|4142->2811|4183->2831|4233->2862|4252->2872|4292->2874|4345->2899|4389->2916|4429->2935|4507->2986|4547->3005|4609->3036|4658->3057|4848->3220|4864->3227|4896->3250|4943->3259|4992->3280|5193->3454|5231->3471|5269->3482|5293->3485|5342->3506|5397->3530|5442->3548|5458->3555|5489->3577|5536->3586|5585->3607|5784->3779|5821->3795|5859->3806|5883->3809|5932->3830|5987->3854|6032->3872|6048->3879|6082->3904|6129->3913|6178->3934|6380->4109|6420->4128|6458->4139|6482->4142|6531->4163|6586->4187|6631->4205|6659->4212|6700->4225|6759->4257|6821->4298|6858->4308|6923->4352|6959->4361|7094->4469|7109->4475|7164->4509
                  LINES: 4->1|5->2|6->3|7->4|8->5|13->7|18->8|19->9|25->15|25->15|25->15|26->16|26->16|29->19|29->19|30->20|30->20|31->21|31->21|31->21|31->21|43->33|43->33|52->42|52->42|56->46|56->46|56->46|56->46|57->47|57->47|57->47|57->47|58->48|58->48|58->48|59->49|59->49|59->49|60->50|61->51|61->51|61->51|62->52|62->52|62->52|63->53|63->53|63->53|64->54|64->54|65->55|66->56|72->62|72->62|72->62|72->62|73->63|75->65|75->65|75->65|75->65|76->66|77->67|78->68|78->68|78->68|78->68|79->69|81->71|81->71|81->71|81->71|82->72|83->73|84->74|84->74|84->74|84->74|85->75|87->77|87->77|87->77|87->77|88->78|89->79|90->80|90->80|91->81|93->83|93->83|94->84|94->84|95->85|96->86|96->86|96->86
                  -- GENERATED --
              */
          