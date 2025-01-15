package co.andrethiele.cdl.di

import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

expect fun platformModule(): Module

val commonModule = module { single { Json { ignoreUnknownKeys = true } } }
