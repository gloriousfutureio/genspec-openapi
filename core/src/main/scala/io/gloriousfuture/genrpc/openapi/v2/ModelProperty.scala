package io.gloriousfuture.genrpc.openapi.v2

import scala.util.Try

sealed trait ModelProperty {
  final def asPrimitive: Option[ModelPrimitive] = this match {
    case prim: ModelPrimitive => Some(prim)
    case _ => None
  }
  final def asRef: Option[ModelRef] = this match {
    case ref: ModelRef => Some(ref)
    case _ => None
  }
}

case class ModelPrimitive(
  `type`: String,
  format: Option[String] = None
) extends ModelProperty

case class ModelRef(id: String, domain: String = "") extends ModelProperty {
  def fullPath: String = s"$domain#$id"
}
object ModelRef {

  def parse(fullPath: String): Try[ModelRef] = Try {
    val parts = fullPath.split('#')
    require(parts.length > 1, "ModelRef path missing '#' seperator")
    val domain = parts(0)
    val uri = parts(1)
    // TODO Validate domain and uri
    ModelRef(uri, domain)
  }

  def fromPath(path: String, domain: String = ""): ModelRef = {
    ModelRef(path.split('.').mkString("/"), domain)
  }
}

object DataTypes {
  final val Object = "object"
}
