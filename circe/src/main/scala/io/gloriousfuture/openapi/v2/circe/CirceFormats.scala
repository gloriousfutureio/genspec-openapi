package io.gloriousfuture.openapi.v2.circe

import io.circe.generic.semiauto._
import io.circe._
import io.circe.syntax._
import io.gloriousfuture.genrpc.openapi.v2._
import cats.syntax.either._

import scala.util.Try

object CirceFormats extends GenericModelFormats[Decoder, Encoder] {

  override implicit lazy val decodeApiPath: Decoder[ApiPath] = Decoder.decodeString.emapTry(ApiPath.parse)
  override implicit lazy val encodeApiPath: Encoder[ApiPath] = Encoder.encodeString.contramap(_.path)

  implicit lazy val keyDecodeApiPath: KeyDecoder[ApiPath] = KeyDecoder.instance(p => Some(ApiPath.parse(p).get))
  implicit lazy val keyEncodeApiPath: KeyEncoder[ApiPath] = KeyEncoder.encodeKeyString.contramap(_.path)

  override implicit lazy val decodeApiPaths: Decoder[Map[ApiPath, PathItem]] = Decoder.decodeMapLike[Map, ApiPath, PathItem]
  override implicit lazy val encodeApiPaths: Encoder[Map[ApiPath, PathItem]] = Encoder.encodeMapLike[Map, ApiPath, PathItem]

  override implicit lazy val decodeContact: Decoder[Contact] = deriveDecoder
  override implicit lazy val encodeContact: Encoder[Contact] = deriveEncoder

  override implicit lazy val decodeDefinitions: Decoder[Map[String, ModelDefinition]] = Decoder.decodeMapLike[Map, String, ModelDefinition]
  override implicit lazy val encodeDefinitions: Encoder[Map[String, ModelDefinition]] = Encoder.encodeMapLike[Map, String, ModelDefinition]

  override implicit lazy val decodeExternalDocs: Decoder[ExternalDocs] = deriveDecoder
  override implicit lazy val encodeExternalDocs: Encoder[ExternalDocs] = deriveEncoder

  override implicit lazy val decodeInfo: Decoder[Info] = deriveDecoder
  override implicit lazy val encodeInfo: Encoder[Info] = deriveEncoder

  override implicit lazy val decodeLicense: Decoder[License] = deriveDecoder
  override implicit lazy val encodeLicense: Encoder[License] = deriveEncoder

  override implicit lazy val decodeModelDefinition: Decoder[ModelDefinition] = deriveDecoder
  override implicit lazy val encodeModelDefinition: Encoder[ModelDefinition] = deriveEncoder

  override implicit lazy val decodeModelProperty: Decoder[ModelProperty] = Decoder.instance { c =>
    c.fieldSet match {
      case Some(fields) if fields contains "$ref" =>
        c.as[ModelRef]
      case _ =>
        c.as[ModelPrimitive]
    }
  }
  override implicit lazy val encodeModelProperty: Encoder[ModelProperty] = Encoder.instance {
    case ref: ModelRef => ref.asJson
    case model: ModelPrimitive => model.asJson
  }

  override implicit lazy val decodeModelRef: Decoder[ModelRef] = Decoder.instanceTry { c =>
    Try(c.downField("$ref").as[String].valueOr(throw _)).flatMap(ModelRef.parse)
  }
  override implicit lazy val encodeModelRef: Encoder[ModelRef] = Encoder.instance { model =>
    Json.obj("$ref" -> Json.fromString(model.fullPath))
  }

  override implicit lazy val decodeModelRefPath: Decoder[ModelRefPath] = Decoder.decodeString.emapTry(ModelRefPath.parse)
  override implicit lazy val encodeModelRefPath: Encoder[ModelRefPath] = Encoder.encodeString.contramap(_.path)

  override implicit lazy val decodeModelPrimitive: Decoder[ModelPrimitive] = deriveDecoder
  override implicit lazy val encodeModelPrimitive: Encoder[ModelPrimitive] = deriveEncoder

  override implicit lazy val decodeParameters: Decoder[Parameters] = deriveDecoder
  override implicit lazy val encodeParameters: Encoder[Parameters] = deriveEncoder

  override implicit lazy val decodePathItem: Decoder[PathItem] = deriveDecoder
  override implicit lazy val encodePathItem: Encoder[PathItem] = deriveEncoder

  override implicit lazy val decodeResponses: Decoder[Responses] = deriveDecoder
  override implicit lazy val encodeResponses: Encoder[Responses] = deriveEncoder

  override implicit lazy val decodeRoot: Decoder[Root] = deriveDecoder
  override implicit lazy val encodeRoot: Encoder[Root] = deriveEncoder

  override implicit lazy val decodeSecurityDefinitions: Decoder[SecurityDefinitions] = deriveDecoder
  override implicit lazy val encodeSecurityDefinitions: Encoder[SecurityDefinitions] = deriveEncoder

  override implicit lazy val decodeSecurityRequirement: Decoder[SecurityRequirement] = deriveDecoder
  override implicit lazy val encodeSecurityRequirement: Encoder[SecurityRequirement] = deriveEncoder

  override implicit lazy val decodeTag: Decoder[Tag] = deriveDecoder
  override implicit lazy val encodeTag: Encoder[Tag] = deriveEncoder

}
