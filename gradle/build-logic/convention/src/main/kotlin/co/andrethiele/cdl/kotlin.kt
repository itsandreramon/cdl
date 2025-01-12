package co.andrethiele.cdl

import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.configure

private fun Project.java(action: JavaPluginExtension.() -> Unit) =
  extensions.configure<JavaPluginExtension>(action)

private fun Project.configureJava() {
  java { toolchain { languageVersion.set(JavaLanguageVersion.of(Versions.JVM_TARGET)) } }
}

fun Project.configureKotlin() {
  configureJava()
}
