ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.15"

libraryDependencies += "com.lihaoyi" %% "upickle" % "4.0.2"

lazy val root = (project in file("."))
  .settings(
    name := "text_quest"
  )
