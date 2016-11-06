package io.gloriousfuture.openapi.v2.yaml

import java.io.StringWriter

import io.circe.Json
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.emitter.Emitter
import org.yaml.snakeyaml.nodes._
import org.yaml.snakeyaml.resolver.Resolver
import org.yaml.snakeyaml.serializer.Serializer

import scala.collection.JavaConverters._

object YamlPrinter extends YamlPrinter
class YamlPrinter {

  protected def toYamlNode(json: Json): Node = {
    json.fold(
      new ScalarNode(Tag.NULL, "null", null, null, '\u0000'),
      b => new ScalarNode(Tag.BOOL, b.toString, null, null, '\u0000'),
      n => {
        val tag = n.toInt.map(_ => Tag.INT) orElse
          n.toShort.map(_ => Tag.INT) orElse
          n.toLong.map(_ => Tag.INT) orElse
          n.toByte.map(_ => Tag.INT) getOrElse
          Tag.FLOAT
        new ScalarNode(tag, n.toString, null, null, '\u0000')
      },
      s => new ScalarNode(Tag.STR, s, null, null, null),
      values => {
        val v = values.map(toYamlNode)
        new SequenceNode(Tag.SEQ, v.asJava, false)
      },
      jo => {
        val vs = jo.toList.map {
          case (k, v) => new NodeTuple(new ScalarNode(Tag.STR, k, null, null, null), toYamlNode(v))
        }
        new MappingNode(Tag.MAP, vs.asJava, false)
      }
    )
  }

  def apply(json: Json, dumperOptions: DumperOptions = new DumperOptions): String = {
    val yaml = toYamlNode(json)
    val writer = new StringWriter()
    val serializer = new Serializer(new Emitter(writer, dumperOptions), new Resolver, dumperOptions, null)
    try {
      serializer.open()
      serializer.serialize(yaml)
      writer.toString
    }
    finally serializer.close()
  }
}
