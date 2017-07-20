import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"

  lazy val config = "com.typesafe" % "config" % "1.3.1"

  val projectDeps = Seq(
    config,
    scalaTest % Test
  )
}
