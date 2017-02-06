package io.gloriousfuture.genrpc.openapi.v2

import scala.util.Try

/**
  * A relative path to an individual endpoint.
  *
  * @note The field name MUST begin with a slash.
  * @note The path is appended to the basePath in order to construct the full URL.
  * @note Path templating is allowed.
  */
case class ApiPath(path: String) {
  require(path.startsWith("/"), "An ApiPath must start with a forward slash '/'")
}
object ApiPath {
  def parse(path: String): Try[ApiPath] = Try(ApiPath(path))
}
