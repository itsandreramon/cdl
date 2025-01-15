plugins {
  `kotlin-dsl`
  alias(libs.plugins.spotless)
}

java { toolchain { languageVersion = JavaLanguageVersion.of(17) } }

val ktfmtVersion = libs.versions.ktfmt.get()

spotless {
  kotlin {
    target("src/**/*.kt")
    ktfmt(ktfmtVersion).googleStyle()
    licenseHeaderFile(rootProject.file("../../spotless/copyright.txt"))
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

dependencies {
  compileOnly(libs.kotlin.gradlePlugin)
  compileOnly(libs.android.gradlePlugin)
  compileOnly(libs.compose.compiler.gradlePlugin)
  compileOnly(libs.compose.multiplatform.gradlePlugin)
  compileOnly(libs.spotless.gradlePlugin)
}

gradlePlugin {
  plugins {
    register("androidApplication") {
      id = "co.andrethiele.cdl.android.application"
      implementationClass = "AndroidApplicationConventionPlugin"
    }

    register("composeMultiplatform") {
      id = "co.andrethiele.cdl.compose.multiplatform"
      implementationClass = "ComposeMultiplatformConventionPlugin"
    }

    register("kotlinMultiplatform") {
      id = "co.andrethiele.cdl.kotlin.multiplatform"
      implementationClass = "KotlinMultiplatformConventionPlugin"
    }
  }
}
