plugins {
  id("co.andrethiele.cdl.android.library")
  id("co.andrethiele.cdl.kotlin.multiplatform")
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

    }

    commonTest.dependencies { implementation(libs.kotlin.test) }
  }
}

android {
  namespace = "co.andrethiele.cdl"
}
