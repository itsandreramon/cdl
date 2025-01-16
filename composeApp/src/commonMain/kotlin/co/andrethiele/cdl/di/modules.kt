// Copyright 2025 - André Thiele

package co.andrethiele.cdl.di

import co.andrethiele.cdl.data.AppCoroutineDispatchers
import co.andrethiele.cdl.feature.players.di.playersModule
import co.andrethiele.cdl.feature.stats.di.statsModule
import co.andrethiele.cdl.feature.teams.di.teamsModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
  appDeclaration()
  modules(commonModule, platformModule, playersModule, teamsModule, statsModule)
}

fun initKoin() = initKoin {}

expect val platformModule: Module

val commonModule = module {
  single { Json { ignoreUnknownKeys = true } }
  single { appCoroutineDispatchers() }
  single { appCoroutineScope(get()) }
  single(named("io")) { ioDispatcher(get()) }
}

private fun appCoroutineScope(dispatchers: AppCoroutineDispatchers): CoroutineScope {
  return CoroutineScope(dispatchers.main + SupervisorJob())
}

private fun appCoroutineDispatchers(): AppCoroutineDispatchers {
  return AppCoroutineDispatchers(
    io = Dispatchers.IO,
    db = Dispatchers.IO.limitedParallelism(1),
    main = Dispatchers.Main,
  )
}

private fun ioDispatcher(dispatchers: AppCoroutineDispatchers): CoroutineDispatcher {
  return dispatchers.io
}
