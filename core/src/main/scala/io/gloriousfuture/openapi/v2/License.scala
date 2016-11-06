package io.gloriousfuture.openapi.v2

import io.circe.generic.JsonCodec
import monocle.macros.Lenses

/**
  * License information for the exposed API.
  */
@JsonCodec @Lenses case class License(

  /**
    * The license name used for the API.
    */
  name: String,

  /**
    * A URL to the license used for the API. MUST be in the format of a URL.
    */
  url: Option[String]
)
object License
