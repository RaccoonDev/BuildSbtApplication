import Dependencies._

enablePlugins(sbtdocker.DockerPlugin)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization          := "com.devraccoon",
      scalaVersion          := "2.12.2",
      version               := "0.1.0-SNAPSHOT",
      mainClass in assembly := Some("Hello")
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test
  )
