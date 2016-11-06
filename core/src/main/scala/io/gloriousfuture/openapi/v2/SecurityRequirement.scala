package io.gloriousfuture.openapi.v2

import io.circe.generic.JsonCodec
import monocle.macros.Lenses

/**
  * Lists the required security schemes to execute this operation.
  *
  * The object can have multiple security schemes declared in it which are all required (that is,
  * there is a logical AND between the schemes).
  *
  * @note The name used for each property MUST correspond to a security scheme declared in the Security Definitions.
  */
@JsonCodec @Lenses case class SecurityRequirement()
object SecurityRequirement
