package io.gloriousfuture.genrpc.openapi.v2

/**
  *
  * @note Missing fields will be parsed as empty strings, unless they are (Required)
  */
case class Root(

  /**
    * (Required) Provides metadata about the API. The metadata can be used by the clients if needed.
    */
  info: Info,

  /**
    * The host (name or ip) serving the API.
    *
    * @note The field value cannot be the empty string.
    * @note This MUST be the host only and does not include the scheme nor sub-paths.
    * @note It MAY include a port.
    * @note If the field is absent, the host serving the documentation is to be used (including the port).
    * @note The host does not support path templating.
    */
  host: Option[String] = None,

  /**
    * The base path on which the API is served, which is relative to the host.
    *
    * @note If it is empty, the API is served directly under the host.
    * @note The value MUST start with a leading slash (/).
    * @note The basePath does not support path templating.
    */
  basePath: Option[String] = None,

  /**
    * The transfer protocol of the API. Values MUST be from the list: "http", "https", "ws", "wss".
    *
    * @note If schemes is empty, the default scheme to be used is the one used to access the Swagger definition itself.
    */
  schemes: Option[Seq[String]] = None,

  /**
    * A list of MIME types the APIs can consume.
    *
    * @note This is global to all APIs but can be overridden on specific API calls.
    * @note Value MUST be as described under Mime Types.
    */
  consumes: Option[Seq[String]] = None,

  /**
    * A list of MIME types the APIs can produce.
    *
    * @note This is global to all APIs but can be overridden on specific API calls.
    * @note Value MUST be as described under Mime Types.
    */
  produces: Option[Seq[String]] = None,

  /**
    * Holds the relative paths to the individual endpoints.
    *
    * @note The path is appended to the basePath in order to construct the full URL.
    * @note The path may not be empty, due to ACL constraints.
    *
    * (Required) The available paths and operations for the API.
    */
  paths: Option[Map[ApiPath, PathItem]] = None,

  /**
    * An object to hold data types produced and consumed by operations.
    * These data types can be primitives, arrays or models.
    */
  definitions: Option[Map[String, ModelDefinition]] = None,

  /**
    * An object to hold parameters that CAN be used across operations.
    *
    * @note This property does not define global parameters for all operations.
    */
  parameters: Option[Parameters] = None,

  /**
    * An object to hold responses that can be used across operations.
    *
    * @note This property does not define global responses for all operations.
    */
  responses: Option[Responses] = None,

  /**
    * Security scheme definitions that can be used across the specification.
    */
  securityDefinitions: Option[SecurityDefinitions] = None,

  /**
    * A declaration of which security schemes are applied for the API as a whole.
    *
    * @see [[SecurityRequirement]]
    * @note Individual operations can override this definition.
    */
  security: Option[Seq[SecurityRequirement]] = None,

  /**
    * A list of tags used by the specification with additional metadata.
    *
    * @note The order of the tags can be used to reflect on their order by the parsing tools.
    * @note Not all tags that are used by the Operation Object must be declared.
    * @note The tags that are not declared may be organized randomly or based on the tools' logic.
    * @note Each tag name in the list MUST be unique.
    */
  tags: Option[Seq[Tag]] = None,

  /**
    * Additional external documentation.
    */
  externalDocs: Option[ExternalDocs] = None
)
