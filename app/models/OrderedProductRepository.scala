package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

/**
  * A repository for people.
  *
  * @param dbConfigProvider The Play db config provider. Play will inject this for you.
  */
@Singleton
class OrderedProductRepository @Inject()(dbConfigProvider: DatabaseConfigProvider, orderRepository: OrderRepository)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._

  /**
    * Here we define the table. It will have a name of people
    */

  class OrderedProductTable(tag: Tag) extends Table[OrderedProduct](tag, "ordered_products") {

    /** The ID column, which is the primary key, and auto incremented */
    def order_id = column[Int]("order_id")
    def product_id = column[Long]("product_id")

    //def order_fk = foreignKey("order_fk",order_id, order)(_.order_id)

    def * = (order_id, product_id) <> ((OrderedProduct.apply _).tupled, OrderedProduct.unapply)
  }

  val orderedProduct = TableQuery[OrderedProductTable]



  def create(newOrderedProduct: OrderedProduct): Future[OrderedProduct] = {
    db.run(orderedProduct += newOrderedProduct).map(res => newOrderedProduct)
  }

  /**
    * List all the people in the database.
    */
  def list(): Future[Seq[OrderedProduct]] = db.run {
    orderedProduct.result
  }

  def getOrderedProductsForGivenOrder(orderId: Int): Future[Seq[OrderedProduct]] = db.run {
    orderedProduct.filter(_.order_id === orderId).result
  }
}
