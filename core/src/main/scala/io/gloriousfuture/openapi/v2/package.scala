package io.gloriousfuture.openapi

package object v2 {

  // TODO: Create case classes to store custom params for these?

  /**
    * Holds the relative paths to the individual endpoints.
    *
    * @note The path is appended to the basePath in order to construct the full URL.
    * @note The Paths may be empty, due to ACL constraints.
    */
  type SwaggerPaths = Map[SwaggerPath, PathItem]

  /**
    * A relative path to an individual endpoint.
    *
    * @note The field name MUST begin with a slash.
    * @note The path is appended to the basePath in order to construct the full URL.
    * @note Path templating is allowed.
    */
  type SwaggerPath = String
  object SwaggerPath {
    def apply(path: String): SwaggerPath = {
      require(path.startsWith("/"), "A SwaggerPath must start with a forward slash '/'")
      path
    }
  }

  /**
    * An object to hold data types that can be consumed and produced by operations.
    * These data types can be primitives, arrays or models.
    */
  type Definitions = Map[Definitions.Name, Schema]
  object Definitions {
    type Name = String
  }

}
