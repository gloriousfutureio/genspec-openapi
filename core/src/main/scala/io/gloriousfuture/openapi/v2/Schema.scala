package io.gloriousfuture.openapi.v2

import io.circe.generic.JsonCodec
import monocle.macros.Lenses

/**
  * A single definition, mapping a "name" to the schema it defines.
  */
@JsonCodec @Lenses case class Schema()
object Schema
