package co.andrethiele.cdl

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

object Versions {
  const val COMPILE_SDK = 35
  const val TARGET_SDK = 35
  const val MIN_SDK = 26
}

val Project.libs
  get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
