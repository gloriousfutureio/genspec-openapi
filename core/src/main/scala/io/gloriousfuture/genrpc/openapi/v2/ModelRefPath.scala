package io.gloriousfuture.genrpc.openapi.v2

import scala.util.Try

case class ModelRefPath(path: String) {
  require(path contains "#/", "A ModelRefPath must contain a '#/' to signify the path")
}
object ModelRefPath {
  def parse(path: String): Try[ModelRefPath] = Try(ModelRefPath(path))
}
