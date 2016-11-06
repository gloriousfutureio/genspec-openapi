package io.gloriousfuture.openapi.v2

import java.io.FileNotFoundException

import cats.data.Xor
import io.circe.Json
import io.circe.parser

import scala.io.Source

object PetstoreExample {

  lazy val asText: String = Option(getClass.getResourceAsStream("/petstore.json")) match {
    case Some(input) => Source.fromInputStream(input).mkString
    case None => throw new FileNotFoundException("Could not find resource /petstore.json")
  }

  lazy val asJson: Json = parser.parse(asText) match {
    case Xor.Right(json) => json
    case Xor.Left(err) =>
      throw new IllegalArgumentException("Could not parse /petstore.json", err)
  }
}
