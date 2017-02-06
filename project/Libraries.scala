import sbt._

object Libraries {

  private val circeVersion = "0.6.0"
  private val circeYamlVersion = "0.3.0"
  private val monocleVersion = "1.3.2"
  private val playVersion = "2.3.10"
  private val scalacheckShapelessVersion = "1.1.3"
  private val scalacheckVersion = "1.13.4"
  private val scalacheckOpsVersion = "1.5.0"
  private val scalatestVersion = "3.0.0"

  val circeCore: ModuleID = "io.circe" %% "circe-core" % circeVersion
  val circeGeneric: ModuleID = "io.circe" %% "circe-generic" % circeVersion
  val circeOptics: ModuleID = "io.circe" %% "circe-optics" % circeVersion
  val circeParser: ModuleID = "io.circe" %% "circe-parser" % circeVersion
  val circeYaml: ModuleID = "io.github.jeremyrsmith" %% "circe-yaml" % circeYamlVersion
  val monocleCore: ModuleID = "com.github.julien-truffaut" %% "monocle-core" % monocleVersion
  val monocleMacro: ModuleID = "com.github.julien-truffaut" %% "monocle-macro" % monocleVersion
  val playServer: ModuleID = "com.typesafe.play" %% "play" % playVersion
  val scalacheckShapeless: ModuleID = "com.github.alexarchambault" %% "scalacheck-shapeless_1.13" % scalacheckShapelessVersion
  val scalacheck: ModuleID = "org.scalacheck" %% "scalacheck" % scalacheckVersion
  val scalacheckOps: ModuleID = "me.jeffmay" %% "scalacheck-ops_1-13" % scalacheckOpsVersion
  val scalatest: ModuleID = "org.scalatest" %% "scalatest" % scalatestVersion
}

object Plugins {

  val macroParadise: Setting[Seq[ModuleID]] = addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.full)
  val playSbtPlugin: Setting[Seq[ModuleID]] = addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.10")
}

object Resolvers {

  val circeYaml: MavenRepository = Resolver.bintrayRepo("jeremyrsmith", "maven")
  val typesafeReleases: MavenRepository = Resolver.typesafeRepo("releases")
}

