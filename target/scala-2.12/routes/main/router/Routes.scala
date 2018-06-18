// @GENERATOR:play-routes-compiler
// @SOURCE:/home/michal/Desktop/ebiznes/play-products-crud-slick-master/conf/routes
// @DATE:Sat Jun 16 01:07:53 CEST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  ProductController_1: controllers.ProductController,
  // @LINE:13
  CategoryController_3: controllers.CategoryController,
  // @LINE:19
  CartController_2: controllers.CartController,
  // @LINE:25
  OrderController_5: controllers.OrderController,
  // @LINE:30
  OpinionController_0: controllers.OpinionController,
  // @LINE:35
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ProductController_1: controllers.ProductController,
    // @LINE:13
    CategoryController_3: controllers.CategoryController,
    // @LINE:19
    CartController_2: controllers.CartController,
    // @LINE:25
    OrderController_5: controllers.OrderController,
    // @LINE:30
    OpinionController_0: controllers.OpinionController,
    // @LINE:35
    Assets_4: controllers.Assets
  ) = this(errorHandler, ProductController_1, CategoryController_3, CartController_2, OrderController_5, OpinionController_0, Assets_4, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ProductController_1, CategoryController_3, CartController_2, OrderController_5, OpinionController_0, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """cat_id<[^/]+>""", """controllers.ProductController.getProducts(cat_id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """prod_id<[^/]+>""", """controllers.ProductController.getProductDataById(prod_id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addproduct""", """controllers.ProductController.addProduct"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteproduct/""" + "$" + """id<[^/]+>""", """controllers.ProductController.deleteProduct(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoryController.getCategories"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categoriesWithCounters""", """controllers.CategoryController.getCategoriesWithCounters"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addcategory""", """controllers.CategoryController.addCategory"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cart""", """controllers.CartController.getCartItems"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addcartitem""", """controllers.CartController.addCartItem"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletecartitem""", """controllers.CartController.deleteCartItem"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders""", """controllers.OrderController.getOrders"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """makeorder""", """controllers.OrderController.makeOrder"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addopinion/""" + "$" + """product_id<[^/]+>""", """controllers.OpinionController.addOpinion(product_id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """opinions/""" + "$" + """product_id<[^/]+>""", """controllers.OpinionController.getOpinions(product_id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_ProductController_getProducts0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("cat_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_getProducts0_invoker = createInvoker(
    ProductController_1.getProducts(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getProducts",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """products/""" + "$" + """cat_id<[^/]+>""",
      """ Products""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ProductController_getProductDataById1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("prod_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_getProductDataById1_invoker = createInvoker(
    ProductController_1.getProductDataById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getProductDataById",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """product/""" + "$" + """prod_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ProductController_addProduct2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addproduct")))
  )
  private[this] lazy val controllers_ProductController_addProduct2_invoker = createInvoker(
    ProductController_1.addProduct,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "addProduct",
      Nil,
      "POST",
      this.prefix + """addproduct""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_ProductController_deleteProduct3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteproduct/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_deleteProduct3_invoker = createInvoker(
    ProductController_1.deleteProduct(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "deleteProduct",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """deleteproduct/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_CategoryController_getCategories4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoryController_getCategories4_invoker = createInvoker(
    CategoryController_3.getCategories,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "getCategories",
      Nil,
      "GET",
      this.prefix + """categories""",
      """ Categories""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_CategoryController_getCategoriesWithCounters5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categoriesWithCounters")))
  )
  private[this] lazy val controllers_CategoryController_getCategoriesWithCounters5_invoker = createInvoker(
    CategoryController_3.getCategoriesWithCounters,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "getCategoriesWithCounters",
      Nil,
      "GET",
      this.prefix + """categoriesWithCounters""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_CategoryController_addCategory6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addcategory")))
  )
  private[this] lazy val controllers_CategoryController_addCategory6_invoker = createInvoker(
    CategoryController_3.addCategory,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "addCategory",
      Nil,
      "POST",
      this.prefix + """addcategory""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_CartController_getCartItems7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cart")))
  )
  private[this] lazy val controllers_CartController_getCartItems7_invoker = createInvoker(
    CartController_2.getCartItems,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "getCartItems",
      Nil,
      "GET",
      this.prefix + """cart""",
      """ Cart""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_CartController_addCartItem8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addcartitem")))
  )
  private[this] lazy val controllers_CartController_addCartItem8_invoker = createInvoker(
    CartController_2.addCartItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "addCartItem",
      Nil,
      "POST",
      this.prefix + """addcartitem""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_CartController_deleteCartItem9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletecartitem")))
  )
  private[this] lazy val controllers_CartController_deleteCartItem9_invoker = createInvoker(
    CartController_2.deleteCartItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "deleteCartItem",
      Nil,
      "POST",
      this.prefix + """deletecartitem""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_OrderController_getOrders10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders")))
  )
  private[this] lazy val controllers_OrderController_getOrders10_invoker = createInvoker(
    OrderController_5.getOrders,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "getOrders",
      Nil,
      "GET",
      this.prefix + """orders""",
      """ Orders""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_OrderController_makeOrder11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("makeorder")))
  )
  private[this] lazy val controllers_OrderController_makeOrder11_invoker = createInvoker(
    OrderController_5.makeOrder,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "makeOrder",
      Nil,
      "POST",
      this.prefix + """makeorder""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_OpinionController_addOpinion12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addopinion/"), DynamicPart("product_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OpinionController_addOpinion12_invoker = createInvoker(
    OpinionController_0.addOpinion(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OpinionController",
      "addOpinion",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """addopinion/""" + "$" + """product_id<[^/]+>""",
      """ Opinions""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_OpinionController_getOpinions13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("opinions/"), DynamicPart("product_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OpinionController_getOpinions13_invoker = createInvoker(
    OpinionController_0.getOpinions(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OpinionController",
      "getOpinions",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """opinions/""" + "$" + """product_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_Assets_versioned14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned14_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_ProductController_getProducts0_route(params@_) =>
      call(params.fromPath[Int]("cat_id", None)) { (cat_id) =>
        controllers_ProductController_getProducts0_invoker.call(ProductController_1.getProducts(cat_id))
      }
  
    // @LINE:7
    case controllers_ProductController_getProductDataById1_route(params@_) =>
      call(params.fromPath[Long]("prod_id", None)) { (prod_id) =>
        controllers_ProductController_getProductDataById1_invoker.call(ProductController_1.getProductDataById(prod_id))
      }
  
    // @LINE:8
    case controllers_ProductController_addProduct2_route(params@_) =>
      call { 
        controllers_ProductController_addProduct2_invoker.call(ProductController_1.addProduct)
      }
  
    // @LINE:9
    case controllers_ProductController_deleteProduct3_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_deleteProduct3_invoker.call(ProductController_1.deleteProduct(id))
      }
  
    // @LINE:13
    case controllers_CategoryController_getCategories4_route(params@_) =>
      call { 
        controllers_CategoryController_getCategories4_invoker.call(CategoryController_3.getCategories)
      }
  
    // @LINE:14
    case controllers_CategoryController_getCategoriesWithCounters5_route(params@_) =>
      call { 
        controllers_CategoryController_getCategoriesWithCounters5_invoker.call(CategoryController_3.getCategoriesWithCounters)
      }
  
    // @LINE:15
    case controllers_CategoryController_addCategory6_route(params@_) =>
      call { 
        controllers_CategoryController_addCategory6_invoker.call(CategoryController_3.addCategory)
      }
  
    // @LINE:19
    case controllers_CartController_getCartItems7_route(params@_) =>
      call { 
        controllers_CartController_getCartItems7_invoker.call(CartController_2.getCartItems)
      }
  
    // @LINE:20
    case controllers_CartController_addCartItem8_route(params@_) =>
      call { 
        controllers_CartController_addCartItem8_invoker.call(CartController_2.addCartItem)
      }
  
    // @LINE:21
    case controllers_CartController_deleteCartItem9_route(params@_) =>
      call { 
        controllers_CartController_deleteCartItem9_invoker.call(CartController_2.deleteCartItem)
      }
  
    // @LINE:25
    case controllers_OrderController_getOrders10_route(params@_) =>
      call { 
        controllers_OrderController_getOrders10_invoker.call(OrderController_5.getOrders)
      }
  
    // @LINE:26
    case controllers_OrderController_makeOrder11_route(params@_) =>
      call { 
        controllers_OrderController_makeOrder11_invoker.call(OrderController_5.makeOrder)
      }
  
    // @LINE:30
    case controllers_OpinionController_addOpinion12_route(params@_) =>
      call(params.fromPath[Long]("product_id", None)) { (product_id) =>
        controllers_OpinionController_addOpinion12_invoker.call(OpinionController_0.addOpinion(product_id))
      }
  
    // @LINE:31
    case controllers_OpinionController_getOpinions13_route(params@_) =>
      call(params.fromPath[Long]("product_id", None)) { (product_id) =>
        controllers_OpinionController_getOpinions13_invoker.call(OpinionController_0.getOpinions(product_id))
      }
  
    // @LINE:35
    case controllers_Assets_versioned14_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned14_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
