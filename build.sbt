organization in ThisBuild := "io.gloriousfuture"
organizationName in ThisBuild := "The Glorious Future"
scalaVersion in ThisBuild := "2.11.8"

lazy val root = Project("openapi-scala-root", file("."))
  .aggregate(core, testing, yaml)
  .settings(
    publish := {},
    publishLocal := {}
  )

val commonSettings = Seq(

  scalacOptions ++= Seq(
    "-deprecation:false",
    "-feature",
    "-language:higherKinds",
    "-target:jvm-1.8",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xfuture",
    "-Ywarn-unused",
    "-Ywarn-value-discard"
  ),

  Plugins.macroParadise,

  libraryDependencies ++= Seq(
    // Core dependencies
    Libraries.circeCore,
    Libraries.circeGeneric,
    Libraries.circeOptics,
    Libraries.circeParser,
    Libraries.monocleCore,
    Libraries.monocleMacro
  ) ++ Seq(
    // Test-only dependencies
    Libraries.scalaTest
  ).map(_ % Test),

  licenses += ("Apache-2.0", url("http://opensource.org/licenses/apache-2.0"))
)

lazy val core = (project in file("core"))
  .settings(commonSettings)
  .settings(
    name := "openapi-scala-core"
  )

lazy val testing = (project in file("testing"))
  .settings(commonSettings)
  .settings(
    name := "openapi-scala-testing",
    libraryDependencies ++= Seq(
      Libraries.scalaTest
    )
  )
  .dependsOn(core)

lazy val yaml = (project in file("yaml"))
  .settings(commonSettings)
  .settings(
    name := "openapi-scala-yaml",
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
  .dependsOn(core, testing % Test)

