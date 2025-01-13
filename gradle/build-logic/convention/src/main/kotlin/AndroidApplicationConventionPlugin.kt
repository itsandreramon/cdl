import co.andrethiele.cdl.configureAndroid
import co.andrethiele.cdl.libs
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) =
    with(target) {
      with(pluginManager) {
        apply("com.android.application")
        apply("org.jetbrains.kotlin.plugin.compose")
      }

      extensions.configure<ApplicationExtension> {
        configureAndroid(this)
        buildFeatures { compose = true }
      }

      dependencies {
        val bom = libs.findLibrary("androidx-compose-bom").get()
        add("implementation", platform(bom))
      }
    }
}
