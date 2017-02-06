package io.gloriousfuture.openapi.v2.circe

import java.io.FileNotFoundException

import cats.syntax.either._
import cats.syntax.show._
import io.circe.Json
import io.circe.optics.JsonPath.root
import io.circe.parser.parse
import io.gloriousfuture.genrpc.openapi.v2.Root
import org.scalatest.{Matchers, WordSpec}

import scala.io.Source
import scala.reflect.ClassTag

class PetstoreExampleSpec extends WordSpec with Matchers {

  import CirceFormats._

  object ExampleJson {
    val petstore: Json = {
      val petstoreExample = Option(getClass.getResource("/petstore.json")) getOrElse {
        throw new FileNotFoundException("Could not find resource /petstore.json")
      }
      parse(Source.fromURL(petstoreExample).mkString).valueOr(throw _)
    }
  }

  def typeName[T](implicit clsTag: ClassTag[T]): String = s"openapi.v2.${clsTag.runtimeClass.getSimpleName}"

  "petstore.json" should {

    s"parse as ${typeName[Root]}" in {
      val result = ExampleJson.petstore.as[Root].valueOr(e => fail(e.show))
      assert(result.info.title contains "Petstore")
      val petModelTypeName = result.definitions.get("Pet").properties("name").asPrimitive.get.`type`
      assertResult("string")(petModelTypeName)
    }

    s"read tags field from ${typeName[Root]}" in {
      val tags = root.tags.each.name.string.getAll(ExampleJson.petstore)
      tags should contain theSameElementsAs Seq("pet", "store", "user")
    }
  }
}
