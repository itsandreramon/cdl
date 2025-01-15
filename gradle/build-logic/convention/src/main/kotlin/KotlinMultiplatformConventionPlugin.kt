// Copyright 2025 - André Thiele

import co.andrethiele.cdl.configureKotlin
import co.andrethiele.cdl.configureSpotless
import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinMultiplatformConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) =
    with(target) {
      with(pluginManager) { apply("org.jetbrains.kotlin.multiplatform") }
      configureSpotless()
      configureKotlin()
    }
}
