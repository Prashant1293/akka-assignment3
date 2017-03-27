name := "akka3"

version := "1.0"

scalaVersion := "2.11.8"

val akkaVersion = "2.4.17"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" % "scalatest" % "3.0.1",
  "log4j" % "log4j" % "1.2.17",
 "org.seleniumhq.selenium" % "selenium-firefox-driver" % "3.0.1",
"org.seleniumhq.selenium" % "selenium-chrome-driver" % "3.0.1",
 "org.seleniumhq.selenium" % "selenium-java" % "3.0.1",
"org.seleniumhq.selenium" % "selenium-server" % "3.0.1"
)

    