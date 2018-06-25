lazy val commonSettings = Seq(
  scalaVersion := "2.12.6",
  sources in(Compile, doc) := Seq()
)

lazy val fp = (project in file("."))
  .settings(commonSettings)

libraryDependencies += "org.typelevel" %% "cats-core" % "1.0.1"
libraryDependencies += "org.typelevel" %% "cats-kernel" % "1.0.1"
