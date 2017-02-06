package io.gloriousfuture.genrpc.openapi.v2

import scala.language.higherKinds

trait GenericModelFormats[D[_], E[_]] {

  implicit def decodeApiPath: D[ApiPath]
  implicit def encodeApiPath: E[ApiPath]

  implicit def decodeApiPaths: D[Map[ApiPath, PathItem]]
  implicit def encodeApiPaths: E[Map[ApiPath, PathItem]]

  implicit def decodeContact: D[Contact]
  implicit def encodeContact: E[Contact]

  // TODO: Use ModelName case class?
  implicit def decodeDefinitions: D[Map[String, ModelDefinition]]
  implicit def encodeDefinitions: E[Map[String, ModelDefinition]]

  implicit def decodeExternalDocs: D[ExternalDocs]
  implicit def encodeExternalDocs: E[ExternalDocs]

  implicit def decodeInfo: D[Info]
  implicit def encodeInfo: E[Info]

  implicit def decodeLicense: D[License]
  implicit def encodeLicense: E[License]

  implicit def decodeModelDefinition: D[ModelDefinition]
  implicit def encodeModelDefinition: E[ModelDefinition]

  implicit def decodeModelProperty: D[ModelProperty]
  implicit def encodeModelProperty: E[ModelProperty]

  implicit def decodeModelPrimitive: D[ModelPrimitive]
  implicit def encodeModelPrimitive: E[ModelPrimitive]

  implicit def decodeModelRef: D[ModelRef]
  implicit def encodeModelRef: E[ModelRef]

  implicit def decodeModelRefPath: D[ModelRefPath]
  implicit def encodeModelRefPath: E[ModelRefPath]

  implicit def decodeParameters: D[Parameters]
  implicit def encodeParameters: E[Parameters]

  implicit def decodePathItem: D[PathItem]
  implicit def encodePathItem: E[PathItem]

  implicit def decodeResponses: D[Responses]
  implicit def encodeResponses: E[Responses]

  implicit def decodeRoot: D[Root]
  implicit def encodeRoot: E[Root]

  implicit def decodeSecurityDefinitions: D[SecurityDefinitions]
  implicit def encodeSecurityDefinitions: E[SecurityDefinitions]

  implicit def decodeSecurityRequirement: D[SecurityRequirement]
  implicit def encodeSecurityRequirement: E[SecurityRequirement]

  implicit def decodeTag: D[Tag]
  implicit def encodeTag: E[Tag]
}
