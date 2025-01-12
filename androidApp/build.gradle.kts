plugins {
  id("co.andrethiele.cdl.android.application")
  id("co.andrethiele.cdl.kotlin.android")
}

android {
  namespace = "co.andrethiele.cdl.android"

  defaultConfig {
    versionCode = 1
    versionName = "1.0"
    applicationId = "co.andrethiele.cdl.android"
  }

  packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
  buildTypes { getByName("release") { isMinifyEnabled = false } }

  kotlinOptions {
    freeCompilerArgs += listOf("-opt-in=androidx.compose.material3.ExperimentalMaterial3Api")
  }
}


dependencies {
  implementation(project(":shared"))
  lintChecks(libs.compose.lints)
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.tooling.preview)
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.activity.compose)
  debugImplementation(libs.androidx.compose.ui.tooling)
  implementation(libs.coil.compose)
  implementation(libs.coil.okhttp)
}
