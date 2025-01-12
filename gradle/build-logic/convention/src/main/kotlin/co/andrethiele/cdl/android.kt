package co.andrethiele.cdl

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure

private fun Project.android(action: BaseExtension.() -> Unit) =
  extensions.configure<BaseExtension>(action)

internal fun Project.configureAndroid() {
  android {
    compileSdkVersion(Versions.COMPILE_SDK)

    defaultConfig {
      minSdk = Versions.MIN_SDK
      targetSdk = Versions.TARGET_SDK
    }
  }

  configureKotlin()
}
