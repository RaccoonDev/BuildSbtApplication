import Dependencies._

enablePlugins(sbtdocker.DockerPlugin)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization          := "com.devraccoon",
      scalaVersion          := "2.12.2",
      version               := "0.4.0-SNAPSHOT"
    )),
    name := "Hello",
    dockerfile in docker := {
      val artifact: File = assembly.value
      val artifactTargetPath = s"/app/${artifact.name}"
      new Dockerfile {
        from("openjdk:alpine")
        add(artifact, artifactTargetPath)
        entryPoint("java", "-jar", artifactTargetPath)
      }
    },
    imageNames in docker := Seq(
      // Sets the latest tag
      ImageName(s"${organization.value}/${name.value}:latest".toLowerCase),

      // Sets a name with a tag that contains the project version
      ImageName(s"${organization.value}/${name.value}:v${version.value.toLowerCase}".toLowerCase)
    ),
    libraryDependencies ++= projectDeps
  )
