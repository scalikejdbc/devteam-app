package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class RootSpec extends Specification {

  "Root" should {

    "send 404 on a bad request" in {
      running(FakeApplication()) {
        route(FakeRequest(GET, "/boum")) must beNone
      }
    }

    "render /" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get
        status(home) must equalTo(303)
        //contentType(home) must beSome.which(_ == "text/html")
        contentType(home) must beNone
      }
    }

  }
}
