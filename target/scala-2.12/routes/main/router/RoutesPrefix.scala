// @GENERATOR:play-routes-compiler
// @SOURCE:/home/michal/Desktop/ebiznes/play-products-crud-slick-master/conf/routes
// @DATE:Mon May 28 21:54:44 CEST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}