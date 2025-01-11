import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
  alias(libs.plugins.androidApplication).apply(false)
  alias(libs.plugins.androidLibrary).apply(false)
  alias(libs.plugins.kotlinAndroid).apply(false)
  alias(libs.plugins.kotlinMultiplatform).apply(false)
  alias(libs.plugins.compose.compiler).apply(false)
  alias(libs.plugins.spotless)
}

val ktfmtVersion = libs.versions.ktfmt.get()

allprojects {
  apply(plugin = "com.diffplug.spotless")

  configure<SpotlessExtension> {
    kotlin {
      target("src/**/*.kt")
      ktfmt(ktfmtVersion).googleStyle()
      trimTrailingWhitespace()
      endWithNewline()
    }

    kotlinGradle {
      target("*.kts", "src/**/*.kts")
      ktfmt(ktfmtVersion).googleStyle()
      trimTrailingWhitespace()
      endWithNewline()
    }
  }
}
