// Copyright 2025 - André Thiele

import co.andrethiele.cdl.Versions
import co.andrethiele.cdl.configureAndroid
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) =
    with(target) {
      with(pluginManager) { apply("com.android.application") }

      extensions.configure<ApplicationExtension> {
        configureAndroid(this)
        defaultConfig { targetSdk = Versions.TARGET_SDK }
      }
    }
}
