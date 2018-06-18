package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.collection.mutable
import scala.concurrent.{ExecutionContext, Future}

/**
  * A repository for people.
  *
  * @param dbConfigProvider The Play db config provider. Play will inject this for you.
  */
@Singleton
class CartRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._


  class CartTable(tag: Tag) extends Table[Cart](tag, "cart") {

    def product_id = column[Long]("product_id")
    def quantity = column[Int]("quantity")

    def * = (product_id , quantity) <> ((Cart.apply _).tupled, Cart.unapply)

  }


  val cart = TableQuery[CartTable]


  def create(item: Cart): Future[Boolean] = {
    db.run(cart.filter(_.product_id === item.product_id).exists.result).flatMap { exists =>
      if(exists) {
        //println(item.product_id + " exists!!")

        /*val q = for { c <- cart if c.product_id == item.product_id } yield c.quantity
        db.run(q.update(10)) // increment*/

        val id = item.product_id

        val action = sql"update cart set quantity = (quantity+1) where product_id == $id".as[(String)]
        db.run(action).map(res => true)
      }
      else {
        //println(item.product_id + " not exists!!")
        db.run(cart += item).map(res => true)
      }
    }
  }

  def delete(product_id: Long): Future[Int] = {
    db.run(cart.filter(_.product_id === product_id).delete)
  }

  def list():Future[Seq[Cart]] = {
    db.run(cart.result)
  }
}
