plugins {
  id("co.andrethiele.cdl.android.application")
  id("co.andrethiele.cdl.kotlin.multiplatform")
  id("co.andrethiele.cdl.compose.multiplatform")
  alias(libs.plugins.kotlin.serialization)
}

kotlin {
  androidTarget()
  listOf(iosArm64(), iosSimulatorArm64()).forEach { iosTarget ->
    iosTarget.binaries.framework {
      baseName = "ComposeApp"
      isStatic = true
    }
  }

  sourceSets {
    androidMain.dependencies {
      implementation(compose.preview)
      implementation(libs.koin.android)
      implementation(libs.androidx.activity.compose)
    }

    commonMain.dependencies {
      implementation(compose.runtime)
      implementation(compose.foundation)
      implementation(compose.material3)
      implementation(compose.ui)
      implementation(compose.components.resources)
      implementation(compose.components.uiToolingPreview)

      implementation(libs.androidx.lifecycle.viewmodel)
      implementation(libs.androidx.lifecycle.runtime.compose)
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.kotlinx.serialization.core)

      implementation(project.dependencies.platform(libs.koin.bom))
      implementation(libs.koin.core)
      implementation(libs.koin.core.viewmodel)
      implementation(libs.koin.compose)
      implementation(libs.koin.compose.viewmodel)

      implementation(libs.coil.compose)
      implementation(libs.coil.ktor)
    }

    commonTest.dependencies { implementation(libs.kotlin.test) }
  }
}

android { namespace = "co.andrethiele.cdl" }

dependencies { debugImplementation(compose.uiTooling) }
