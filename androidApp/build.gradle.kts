plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
}

android {
  namespace = "co.andrethiele.cdl.android"
  compileSdk = 35

  defaultConfig {
    minSdk = 26
    targetSdk = 35

    versionCode = 1
    versionName = "1.0"
    applicationId = "co.andrethiele.cdl.android"
  }

  buildFeatures { compose = true }
  packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
  buildTypes { getByName("release") { isMinifyEnabled = false } }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
  implementation(project(":shared"))
  lintChecks(libs.compose.lints)

  implementation(libs.compose.ui)
  implementation(libs.compose.ui.tooling.preview)
  implementation(libs.compose.material3)
  implementation(libs.androidx.activity.compose)
  debugImplementation(libs.compose.ui.tooling)
}
