// @GENERATOR:play-routes-compiler
// @SOURCE:/home/michal/Desktop/ebiznes/play-products-crud-slick-master/conf/routes
// @DATE:Mon May 28 21:54:44 CEST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:28
  class ReverseOpinionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def writeOpinion(product_id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "writeopinion/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("product_id", product_id)))
    }
  
    // @LINE:30
    def getOpinions(product_id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "opinions/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("product_id", product_id)))
    }
  
    // @LINE:29
    def addOpinion(product_id:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addopinion/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("product_id", product_id)))
    }
  
  }

  // @LINE:34
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:17
  class ReverseCartController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def addCartItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addcartitem")
    }
  
    // @LINE:19
    def deleteCartItem(product_id:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deletecartitem/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("product_id", product_id)))
    }
  
    // @LINE:17
    def getCartItems(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cart")
    }
  
  }

  // @LINE:12
  class ReverseCategoryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def addCategory(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addcategory")
    }
  
    // @LINE:12
    def getCategories(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories")
    }
  
  }

  // @LINE:6
  class ReverseProductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def addProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addproduct")
    }
  
    // @LINE:6
    def getProducts(cat_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("cat_id", cat_id)))
    }
  
    // @LINE:8
    def deleteProduct(id:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteproduct/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:23
  class ReverseOrderController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def makeOrder(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "makeorder")
    }
  
    // @LINE:23
    def getOrders(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "orders")
    }
  
  }


}
