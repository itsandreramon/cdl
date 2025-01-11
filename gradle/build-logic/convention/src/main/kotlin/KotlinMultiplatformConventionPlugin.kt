import co.andrethiele.cdl.configureSpotless
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) =
    with(target) {
      with(pluginManager) { apply("org.jetbrains.kotlin.multiplatform") }

      extensions.configure<KotlinMultiplatformExtension> {
        if (pluginManager.hasPlugin("com.android.library")) {
          androidTarget {

          }
        }

        iosArm64()
        iosSimulatorArm64()
      }

      configureSpotless()
      configureKotlin()
    }
}
