package io.gloriousfuture.openapi.v2

import io.circe.generic.JsonCodec
import monocle.macros.Lenses

/**
  *
  */
@JsonCodec @Lenses case class Tag(
  name: String,
  description: String
)
object Tag
