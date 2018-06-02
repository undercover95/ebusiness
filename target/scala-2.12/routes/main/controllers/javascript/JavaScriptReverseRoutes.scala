// @GENERATOR:play-routes-compiler
// @SOURCE:/home/michal/Desktop/ebiznes/play-products-crud-slick-master/conf/routes
// @DATE:Sat Jun 02 22:37:28 CEST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:29
  class ReverseOpinionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def writeOpinion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OpinionController.writeOpinion",
      """
        function(product_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "writeopinion/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("product_id", product_id0))})
        }
      """
    )
  
    // @LINE:31
    def getOpinions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OpinionController.getOpinions",
      """
        function(product_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "opinions/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("product_id", product_id0))})
        }
      """
    )
  
    // @LINE:30
    def addOpinion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OpinionController.addOpinion",
      """
        function(product_id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addopinion/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("product_id", product_id0))})
        }
      """
    )
  
  }

  // @LINE:35
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseCartController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def deleteCartItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CartController.deleteCartItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletecartitem"})
        }
      """
    )
  
    // @LINE:19
    def addCartItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CartController.addCartItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addcartitem"})
        }
      """
    )
  
    // @LINE:18
    def getCartItems: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CartController.getCartItems",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cart"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseCategoryController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def getCategoriesWithCounters: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoryController.getCategoriesWithCounters",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "categoriesWithCounters"})
        }
      """
    )
  
    // @LINE:14
    def addCategory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoryController.addCategory",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addcategory"})
        }
      """
    )
  
    // @LINE:12
    def getCategories: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoryController.getCategories",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "categories"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseProductController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def addProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductController.addProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addproduct"})
        }
      """
    )
  
    // @LINE:6
    def getProducts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductController.getProducts",
      """
        function(cat_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("cat_id", cat_id0))})
        }
      """
    )
  
    // @LINE:8
    def deleteProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductController.deleteProduct",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteproduct/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:24
  class ReverseOrderController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def makeOrder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderController.makeOrder",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "makeorder"})
        }
      """
    )
  
    // @LINE:24
    def getOrders: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderController.getOrders",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "orders"})
        }
      """
    )
  
  }


}
