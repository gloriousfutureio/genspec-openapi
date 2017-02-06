package io.gloriousfuture.genrpc.openapi.v2

/**
  * License information for the exposed API.
  */
case class License(

  /**
    * The license name used for the API.
    */
  name: String,

  /**
    * A URL to the license used for the API. MUST be in the format of a URL.
    */
  url: Option[String] = None
)
