import sbt._

object Libraries {

  private val circeVersion = "0.5.4"
  private val circeYamlVersion = "0.2.1"
  private val monocleVersion = "1.3.2"
  private val scalacheckVersion = "1.13.2"
  private val scalacheckOpsVersion = "1.5.0"
  private val scalaTestVersion = "3.0.0"

  val circeCore = "io.circe" %% "circe-core" % circeVersion
  val circeGeneric = "io.circe" %% "circe-generic" % circeVersion
  val circeOptics = "io.circe" %% "circe-optics" % circeVersion
  val circeParser = "io.circe" %% "circe-parser" % circeVersion
  val circeYaml = "io.github.jeremyrsmith" %% "circe-yaml" % circeYamlVersion
  val monocleCore = "com.github.julien-truffaut" %% "monocle-core" % monocleVersion
  val monocleMacro = "com.github.julien-truffaut" %% "monocle-macro" % monocleVersion
  val scalacheck = "org.scalacheck" %% "scalacheck" % scalacheckVersion
  val scalacheckOps = "me.jeffmay" %% "scalacheck-ops_1-13" % scalacheckOpsVersion
  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion
}

object Plugins {

  val macroParadise = addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.full)
}

object Resolvers {
  
  val circeYaml = Resolver.bintrayRepo("jeremyrsmith", "maven")
}

