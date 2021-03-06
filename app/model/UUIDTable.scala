package model

import java.util.UUID

import play.api.Logger
//import slick.jdbc.MySQLProfile.api._
import profile.CustomMySqlProfile.api._
import slick.lifted.Tag
import slick.sql.SqlProfile.ColumnOption.SqlType

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

case class UUIDTest(id: Int, testId: UUID)

class UUIDTestStoreTable(tag: Tag) extends Table[UUIDTest](tag, "UUIDTest") {
  def id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def testId = column[UUID]("testId", SqlType("VARCHAR(36)"))

  def * = (id, testId) <> (UUIDTest.tupled, UUIDTest.unapply)
}


object UUIDTestStore {
  private val db = Database.forConfig("db.default")

  private val table = TableQuery[UUIDTestStoreTable]

  def find(testId: UUID): Future[Option[UUIDTest]] = {
    db.run {
      table.filter(_.testId === testId).result
    }.map(_.headOption)
  }

  def find2(testId: UUID): Future[Option[UUIDTest]] = {
    db.run {
      table.result
    }.map(_.filter(_.testId == testId)).map(_.headOption)
  }

}
