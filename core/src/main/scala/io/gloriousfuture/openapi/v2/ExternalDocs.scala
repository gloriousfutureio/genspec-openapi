package io.gloriousfuture.openapi.v2

import io.circe.generic.JsonCodec
import monocle.macros.Lenses

@JsonCodec @Lenses case class ExternalDocs(
  description: String,
  url: String
)
object ExternalDocs
