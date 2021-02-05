val root = project.in(file("."))
    .settings(GenJavadocPlugin.projectSettings, PublishJavadocPlugin.projectSettings)
    .settings(
        scalaVersion := "2.13.4", // works for Scala 2.13.3
        unidocGenjavadocVersion := "0.16",
    )