import Dependencies._
import sbtassembly._

enablePlugins(sbtdocker.DockerPlugin)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization          := "com.devraccoon",
      scalaVersion          := "2.12.2",
      version               := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    dockerfile in docker := {
      val artifact: File = assembly.value
      val artifactTargetPath = s"/app/${artifact.name}"
      new Dockerfile {
        from("java")
        add(artifact, artifactTargetPath)
        entryPoint("java", "-jar", artifactTargetPath)
      }
    },
    libraryDependencies += scalaTest % Test
  )
