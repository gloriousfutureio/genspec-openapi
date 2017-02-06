package io.gloriousfuture.genrpc.openapi.v2

/**
  * Contact information for the exposed API.
  */
case class Contact(

  /**
    * The identifying name of the contact person/organization.
    */
  name: Option[String] = None,

  /**
    * The URL pointing to the contact information.
    *
    * MUST be in the format of a URL.
    */
  url: Option[String] = None,

  /**
    * The email address of the contact person/organization.
    *
    * MUST be in the format of an email address.
    */
  email: Option[String] = None
)
