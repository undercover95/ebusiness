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
class OpinionRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._


  class OpinionTable(tag: Tag) extends Table[Opinion](tag, "opinions") {

    /** The ID column, which is the primary key, and auto incremented */
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

    /** The name column */
    def product_id = column[Long]("product_id")

    def title = column[String]("title")

    def opinion = column[String]("opinion")

    def * = (product_id, title, opinion) <> ((Opinion.apply _).tupled, Opinion.unapply)
  }


  val opinion = TableQuery[OpinionTable]

  def create(op: Opinion): Future[Opinion] = {
    db.run(opinion += op).map(res => op)
  }

  def list(product_id: Long): Future[Seq[Opinion]] = db.run {
    opinion.filter((_.product_id === product_id)).result
  }
}
