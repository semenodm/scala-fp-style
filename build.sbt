lazy val commonSettings = Seq(
  scalaVersion := "2.12.6",
  sources in(Compile, doc) := Seq()
)

lazy val fp = (project in file("."))
  .settings(commonSettings)

