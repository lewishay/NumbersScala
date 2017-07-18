name := "Numbers"

version := "1.0"

scalaVersion := "2.12.1"

wartremoverErrors ++= Warts.unsafe
wartremoverExcluded += baseDirectory.value / "src" / "test" / "scala" / "NumberTest.scala"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
        