name := "battleship"

version := "1.0"

scalaVersion := "2.11.6"

lazy val akkaV = "2.3.9"

lazy val akkaDeps = Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.9",
  "com.typesafe.akka" %% "akka-remote" % "2.3.9"
)

lazy val scalatest = "org.scalatest" %% "scalatest" % "2.2.4" % "test"

lazy val lanterna = "com.googlecode.lanterna" % "lanterna" % "3.0.0-alpha6"

libraryDependencies ++= akkaDeps :+ scalatest

lazy val client = project.in(file("client")).settings(
  libraryDependencies ++= akkaDeps ++ Seq(
    scalatest, lanterna
  )
)
