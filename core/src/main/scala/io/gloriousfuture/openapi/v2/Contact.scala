package io.gloriousfuture.openapi.v2

import io.circe.generic.JsonCodec
import monocle.macros.Lenses

/**
  * Contact information for the exposed API.
  */
@JsonCodec @Lenses case class Contact(

  /**
    * The identifying name of the contact person/organization.
    */
  name: Option[String],

  /**
    * The URL pointing to the contact information.
    *
    * MUST be in the format of a URL.
    */
  url: Option[String],

  /**
    * The email address of the contact person/organization.
    *
    * MUST be in the format of an email address.
    */
  email: Option[String]
)
object Contact
