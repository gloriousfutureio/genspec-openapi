// TODO: Move to client generation project

//package io.gloriousfuture.genrpc.openapi.v2
//
//import cats.syntax.either._
//import io.gloriousfuture.genrpc._
//
//class OpenApiV2JsonTransformer(packagePrefix: String) extends SpecTransformer {
//
//  override def transform(spec: String): RpcPackage = {
//    val json = io.circe.parser.parse(spec).valueOr(throw _)
//    val api = json.as[Root].valueOr(throw _)
//    val definitions = api.definitions.getOrElse(Definitions.empty)
//    val sortedModels = definitions.toSeq.map {
//      case (name, schema) => extractModel(name, schema)
//    }.sortBy(_.name)
//    val modelPackageRoot = (packagePrefix.split('.') :+ "models").mkString(".")
//    val modelFiles = sortedModels.map { model =>
//      ModelFile(modelPackageRoot, Imports.empty, Seq(model))
//    }
//    RpcPackage(modelPackageRoot, modelFiles)
//  }
//
//  def extractModel(name: Identifier, schema: ModelDefinition): Model = {
//    val properties = schema.properties.toSeq
//    val fields = properties.map {
//      case (k, v: ModelRef) =>
//        Field(k, v.id.split('/').mkString("."))
//    }
//    CaseClass(name, Seq(), fields, Seq())
//  }
//}
