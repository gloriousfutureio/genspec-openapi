package io.gloriousfuture.openapi.v2

import io.circe.Json
import io.circe.optics.JsonPath.root
import org.scalatest._

trait PetstoreExampleTests extends Matchers {
  self: Suite with TestRegistration =>

  protected def loadPetstoreExample(): Json

  protected lazy val petstoreJson: Json = loadPetstoreExample()

  protected def prefix: String = "PetstoreExampleTests"

  registerTest(s"[$prefix] load from Json file") {
    petstoreJson
  }

  registerTest(s"[$prefix] extract the file as an OpenAPI spec") {
    val root = petstoreJson.as[Root]
    assert(root.isRight)
  }

  registerTest(s"[$prefix] extract all tags from OpenAPI spec") {
    val tags = root.tags.each.name.string.getAll(petstoreJson)
    tags should contain theSameElementsAs Seq("pet", "store", "user")
  }
}


