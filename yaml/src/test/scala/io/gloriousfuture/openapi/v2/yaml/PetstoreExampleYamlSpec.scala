package io.gloriousfuture.openapi.v2.yaml

import io.circe.Json
import io.circe.yaml.printer.Printer
import io.circe.yaml.parser.Parser
//import io.gloriousfuture.openapi.v2.{PetstoreExample, PetstoreExampleTests}
import org.scalatest.FreeSpec

//class PetstoreExampleYamlSpec extends FreeSpec with PetstoreExampleTests {
//
//  override protected def loadPetstoreExample(): Json = {
//    val petstoreYaml = Printer(PetstoreExample.asJson)
//    Parser.parse(petstoreYaml) match {
//      case Right(json) => json
//      case Left(err) =>
//        throw new IllegalArgumentException(s"Could not parse YAML reserialized from /petstore.json...\n$petstoreYaml", err)
//    }
//  }
//}
