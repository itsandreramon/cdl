package co.andrethiele.cdl

import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonCompilerOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

private fun Project.java(action: JavaPluginExtension.() -> Unit) =
  extensions.configure<JavaPluginExtension>(action)

private fun Project.kotlin(action: KotlinProjectExtension.() -> Unit) =
  extensions.configure<KotlinProjectExtension>(action)

private fun Project.configureJava() {
  java { toolchain { languageVersion.set(JavaLanguageVersion.of(Versions.JVM_TARGET)) } }
}

private fun KotlinProjectExtension.compilerOptions(block: KotlinCommonCompilerOptions.() -> Unit) {
  when (this) {
    is KotlinJvmProjectExtension -> compilerOptions.block()
    is KotlinAndroidProjectExtension -> compilerOptions.block()
    is KotlinMultiplatformExtension -> {
      targets.all {
        compilations.all { compileTaskProvider.configure { compilerOptions { block() } } }
      }
    }

    else -> error("Unknown kotlin extension $this")
  }
}

fun Project.configureKotlin() {
  configureJava()
  kotlin {
    compilerOptions {
      allWarningsAsErrors = true
      freeCompilerArgs.add("-Xexpect-actual-classes")
    }
  }
}
