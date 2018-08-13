name := "bad_reflection"
organization := "org.scalamacros"
version := "2.0.0"

//scalaVersion in ThisBuild := "2.12.4" //OK
//scalaVersion in ThisBuild := "2.12.6" //OK
//scalaVersion in ThisBuild := "2.13.0-M2" //OK
//scalaVersion in ThisBuild := "2.13.0-M3" //BAD
scalaVersion in ThisBuild := "2.13.0-pre-f1194e6" //BAD

  lazy val macros = (project in file("macros")).settings(
 libraryDependencies ++= Seq(
   "org.scala-lang" % "scala-reflect" % scalaVersion.value
 ),
 scalacOptions ++= Seq(
   "-language:experimental.macros",
   "-language:higherKinds",
   "-language:implicitConversions"
 ),
    resolvers += "scala-integration" at
      "https://scala-ci.typesafe.com/artifactory/scala-integration/",
  autoScalaLibrary := false

)

autoScalaLibrary := false

lazy val core = project in file("core") dependsOn macros settings (
  resolvers += "scala-integration" at
    "https://scala-ci.typesafe.com/artifactory/scala-integration/"

  //  scalacOptions ++= Seq(
//    "-Xprint:typer",
//    "-Ymacro-debug-lite",
//    "-Xlog-implicits",
//    "-Ytyper-debug"
//  )
)
resolvers += "scala-integration" at
  "https://scala-ci.typesafe.com/artifactory/scala-integration/"
