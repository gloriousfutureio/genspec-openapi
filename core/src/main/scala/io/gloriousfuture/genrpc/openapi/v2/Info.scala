package io.gloriousfuture.genrpc.openapi.v2

/**
  * The object provides metadata about the API.
  *
  * The metadata can be used by the clients if needed, and can be presented in the Swagger-UI for convenience.
  */
case class Info(

  /**
    * (Required) The title of the application.
    *
    * @note it is illegal for the value to be the empty string.
    */
  title: String,

  /**
    * (Required) Provides the version of the application API (not to be confused with the specification version).
    *
    * @note it is illegal for the value to be the empty string.
    */
  version: String,

  /**
    * A short description of the application. GFM syntax can be used for rich text representation.
    */
  description: Option[String] = None,

  /**
    * The Terms of Service for the API.
    */
  termsOfService: Option[String] = None,

  /**
    * The contact information for the exposed API.
    */
  contact: Option[Contact] = None,

  /**
    * The license information for the exposed API.
    */
  license: Option[License] = None
)
