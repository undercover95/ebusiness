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
class CartRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._

  /**
    * Here we define the table. It will have a name of people
    */
  class CartTable(tag: Tag) extends Table[Cart](tag, "cart") {

    /** The ID column, which is the primary key, and auto incremented */
    def product_id = column[Long]("product_id")

    /**
      * This is the tables default "projection".
      *
      * It defines how the columns are converted to and from the Person object.
      *
      * In this case, we are simply passing the id, name and page parameters to the Person case classes
      * apply and unapply methods.
      */
    def * = product_id <> ((Cart.apply _), Cart.unapply)

  }

  /**
    * The starting point for all queries on the people table.
    */
  val cart = TableQuery[CartTable]



  /**
    * Create a person with the given name and age.
    *
    * This is an asynchronous operation, it will return a future of the created person, which can be used to obtain the
    * id for that person.
    */
  def create(item: Cart): Future[Cart] = {
    db.run(cart += item).map(res => item)
  }

  def delete(item: Cart): Future[Int] = {
    db.run(cart.filter(_.product_id === item.product_id).delete)
  }

  def list(): Future[Seq[Cart]] = db.run {
    cart.groupBy(_.product_id).map{
      case (res) => res
    }
  }
}
