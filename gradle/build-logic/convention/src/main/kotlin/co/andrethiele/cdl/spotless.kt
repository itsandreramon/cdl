package co.andrethiele.cdl

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

private fun Project.spotless(action: SpotlessExtension.() -> Unit) =
  extensions.configure<SpotlessExtension>(action)

fun Project.configureSpotless() {
  with(pluginManager) { apply("com.diffplug.spotless") }

  val ktfmtVersion = libs.findVersion("ktfmt").get()

  spotless {
    kotlin {
      target("src/**/*.kt")
      ktfmt(ktfmtVersion.displayName).googleStyle()
      trimTrailingWhitespace()
      endWithNewline()
    }

    kotlinGradle {
      target("*.kts", "src/**/*.kts")
      ktfmt(ktfmtVersion.displayName).googleStyle()
      trimTrailingWhitespace()
      endWithNewline()
    }
  }
}
