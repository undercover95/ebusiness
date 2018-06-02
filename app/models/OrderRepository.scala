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
class OrderRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._

  /**
    * Here we define the table. It will have a name of people
    */
  class OrderTable(tag: Tag) extends Table[Order](tag, "orders") {

    /** The ID column, which is the primary key, and auto incremented */
    def order_id = column[Int]("order_id", O.PrimaryKey, O.AutoInc)

    def * = order_id <> ((Order.apply _), Order.unapply)
  }

  /**
    * The starting point for all queries on the people table.
    */
  val order = TableQuery[OrderTable]



  /**
    * Create a person with the given name and age.
    *
    * This is an asynchronous operation, it will return a future of the created person, which can be used to obtain the
    * id for that person.
    */
  def create(newOrder: Order): Future[Order] = db.run {
    (order returning order.map(_.order_id) into ((newOrder, order_id) => Order(order_id))) += (newOrder)
  }

  /**
    * List all the people in the database.
    */
  def list(): Future[Seq[Order]] = db.run {
    order.result
  }
}
