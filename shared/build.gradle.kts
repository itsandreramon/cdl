plugins {
  id("co.andrethiele.cdl.android.library")
  id("co.andrethiele.cdl.kotlin.multiplatform")
  alias(libs.plugins.kotlin.serialization)
}

kotlin {
  listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach {
    it.binaries.framework {
      baseName = "shared"
      isStatic = true
    }
  }

  sourceSets {
    commonMain.dependencies {
      implementation(libs.kotlin.serialization.json)
      implementation(project.dependencies.platform(libs.koin.bom))
      implementation(libs.koin.core)
    }
    commonTest.dependencies {
      implementation(libs.kotlin.test)
    }
  }
}

android { namespace = "co.andrethiele.cdl" }
