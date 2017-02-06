package io.gloriousfuture.genrpc.openapi.v2

/**
  * A single definition, mapping a "name" to the schema it defines.
  */
case class ModelDefinition(
  `type`: String,
  properties: Map[String, ModelProperty] = Map.empty
)
