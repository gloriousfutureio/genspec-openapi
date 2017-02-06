organization in ThisBuild := "io.gloriousfuture"
organizationName in ThisBuild := "The Glorious Future"

version in ThisBuild := "0.0.1"
scalaVersion in ThisBuild := "2.11.8"
crossScalaVersions in ThisBuild := Seq("2.10.6", "2.11.8")

licenses in ThisBuild += ("Apache-2.0", url("http://opensource.org/licenses/apache-2.0"))

lazy val root = Project("genspec-openapi", file("."))
  .aggregate(
    `genspec-openapi-core`,
    `genspec-openapi-circe`,
    `genspec-openapi-play`,
    `genspec-openapi-yaml`
  )
  .settings(
    publish := {},
    publishLocal := {}
  )

def commonProject(id: String, path: String): Project = {
  Project(id, file(path)).settings(

    name := id,
    scalaVersion := "2.11.8",
    crossScalaVersions := Seq("2.11.8"),
    scalacOptions ++= {
      // the deprecation:false flag is only supported by scala >= 2.11.3, but needed for scala >= 2.11.0 to avoid warnings
      (CrossVersion.partialVersion(scalaVersion.value) match {

        case Some((2, scalaMinor)) if scalaMinor >= 11 =>
          // For scala versions >= 2.11.3
          Seq("-deprecation:false", "-target:jvm-1.8", "-Ywarn-unused")

        case Some((2, scalaMinor)) if scalaMinor < 11 =>
          // For scala versions 2.10.x we can't use certain flags
          Seq.empty

      }) ++ Seq(
        "-feature",
        "-unchecked",
        "-Xfatal-warnings",
        "-Xfuture",
        "-Ywarn-value-discard"
      )
    },

    // Every project gets scalatest
    libraryDependencies += Libraries.scalatest % Test
  )
}

/**
  * Generic code to allow converting models to OpenAPI specs.
  */
lazy val `genspec-openapi-core` = commonProject("genspec-openapi-core", "core")
  .settings(
    // Cross-compile for sbt plugin
    crossScalaVersions := Seq("2.10.6", "2.11.8"),
    libraryDependencies ++= Seq(
      Libraries.scalacheck,
      Libraries.scalacheckShapeless
    )
  )

/**
  * Build OpenAPI specs from circe model serializers.
  */
lazy val `genspec-openapi-circe` = commonProject("genspec-openapi-circe", "circe")
  .settings(
    Plugins.macroParadise,
    libraryDependencies ++= Seq(
      Libraries.circeGeneric,
      Libraries.circeOptics,
      Libraries.circeParser
    )
  )
  .dependsOn(`genspec-openapi-core`)

/**
  * Print YAML for circe projects.
  */
lazy val `genspec-openapi-yaml` = commonProject("genspec-openapi-yaml", "yaml")
  .settings(
    resolvers ++= Seq(
      Resolvers.circeYaml
    ),
    libraryDependencies ++= Seq(
      Libraries.circeYaml
    ) ++ Seq(
      // Test-only dependencies
      Libraries.scalacheckOps
    ).map(_ % Test)
  )
  .dependsOn(`genspec-openapi-core`, `genspec-openapi-circe`)

/**
  * Build OpenAPI specs from Play routes, controllers, and play model serializers.
  */
lazy val `genspec-openapi-play` = commonProject("genspec-openapi-play", "play")
  .settings(
    resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
    libraryDependencies ++= Seq(
      Libraries.playServer
    )
  )
  .dependsOn(`genspec-openapi-core`)
