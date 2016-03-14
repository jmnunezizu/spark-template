organization := "com.github.jmnunezizu"

name := "spark-template"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.8"

javacOptions ++= Seq("-source", "1.8")

// Resolvers
resolvers ++= Seq(
  Resolver.jcenterRepo,
  "scalaz bintray" at "https://dl.bintray.com/scalaz/releases",
  "sonatype releases" at "https://oss.sonatype.org/content/repositories/releases/"
)

// Dependencies

val testDependencies = Seq(
  "org.specs2" %% "specs2-core" % "3.6.4" % "test"
)

val sparkVersion = "1.6.1"

val rootDependencies = Seq(
  "com.iheart" %% "ficus" % "1.2.0",

  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion
)

libraryDependencies ++= testDependencies ++ rootDependencies

scalacOptions in Test ++= Seq("-Yrangepos")
