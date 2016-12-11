import java.util.UUID

import model.UUIDTestStore
import org.specs2.concurrent.ExecutionEnv
import org.specs2.mutable._
import play.api.Play
import play.api.test.FakeApplication

import scala.concurrent.Await
import scala.concurrent.duration._

class UUIDSpec(implicit ee: ExecutionEnv) extends Specification {
  sequential

  val app = FakeApplication()

  step(Play.start(app))
  "Spec" should {

    "Find an id with slick filter" in {
      val idToFind = UUID.fromString("6623dafd-da75-4f4c-854e-76f6ec63a5a2")
      val result = UUIDTestStore.find(idToFind)
      Await.ready(result, Duration(5, SECONDS))
      println("------------")
      println(result.value.get.toOption.get)
      println("------------")
      result.value.get.toOption.flatMap(_.map(_.testId)) must beEqualTo(Some(idToFind))
    }

    "Find an id without slick filter" in {
      val idToFind = UUID.fromString("6623dafd-da75-4f4c-854e-76f6ec63a5a2")
      val result2 = UUIDTestStore.find2(idToFind)
      Await.ready(result2, Duration(5, SECONDS))
      println("------------")
      println(result2.value.get.toOption.get)
      println("------------")
      result2.value.get.toOption.flatMap(_.map(_.testId)) must beEqualTo(Some(idToFind))
    }
  }
  step(Play.stop(app))

}
