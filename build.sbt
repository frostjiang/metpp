import sbt.Keys._

lazy val commonSettings = Seq(
  organization := "edu.louisville",
  version := "1.0",
  scalaVersion := Version.scala,
  crossScalaVersions := Seq("2.11.7", "2.10.4"),
  libraryDependencies ++= Seq(
    Library.breeze,
    Library.breezeConfig,
    Library.mapdb,
    Library.scalaLoggingSlf4j,
    Library.tikaParsers % "compile,optional",
    Library.boilerpipe,
    Library.nekohtml,
    Library.slf4jSimple,
    Library.commonsLang3,
    Library.jflex,
    Library.scalatest % "test",
    Library.scalacheck % "test",
    Library.junit % "test",
    Library.jodatime,
    Library.jodaconvert
  ),
  scalacOptions ++= Seq("-deprecation", "-language:_", "-optimize"),
  javaOptions += "-Xmx4g",
  javaOptions += "-Xrunhprof:cpu=samples,depth=12",
  fork := true,
//  publishMavenStyle := true,
//  publishTo <<= version { (v: String) =>
//    val nexus = "https://oss.sonatype.org/"
//    if (v.trim.endsWith("SNAPSHOT"))
//      Some("snapshots" at nexus + "content/repositories/snapshots")
//    else
//      Some("releases" at nexus + "service/local/staging/deploy/maven2")
//  },
//  publishArtifact in Test := false,
//  pomIncludeRepository := { _ => false },
//  assemblyOption in assembly ~= {
//    _.copy(cacheOutput = false)
//  },
  resolvers ++= Seq(
    "ScalaNLP Maven2" at "http://repo.scalanlp.org/repo",
    "Scala Tools Snapshots" at "http://scala-tools.org/repo-snapshots/",
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
  ),
  libraryDependencies ++= (CrossVersion.partialVersion(scalaVersion.value) match {
    // if scala 2.11+ is used, add dependency on scala-xml module
    case Some((2, scalaMajor)) if scalaMajor >= 11 =>
      Seq("org.scala-lang.modules" %% "scala-xml" % "1.0.1")
    case _ =>
      Seq.empty
  })

)

lazy val metppCore = project
  .in(file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "metpp"
  )