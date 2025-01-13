package co.andrethiele.cdl

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

internal fun Project.configureAndroid(extension: CommonExtension<*, *, *, *, *, *>) {
  extension.apply {
    compileSdk = Versions.COMPILE_SDK
    defaultConfig { minSdk = Versions.MIN_SDK }

    compileOptions {
      targetCompatibility = JavaVersion.toVersion(Versions.JVM_TARGET)
      sourceCompatibility = JavaVersion.toVersion(Versions.JVM_TARGET)
    }
  }

  configureKotlin()
}
