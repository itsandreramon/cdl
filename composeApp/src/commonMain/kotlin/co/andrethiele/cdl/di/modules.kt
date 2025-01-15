package co.andrethiele.cdl.di

import co.andrethiele.cdl.data.CoroutineDispatchers
import co.andrethiele.cdl.feature.players.di.playersModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
  appDeclaration()
  modules(commonModule, platformModule, playersModule)
}

expect val platformModule: Module

val commonModule = module {
  single { Json { ignoreUnknownKeys = true } }
  single { CoroutineDispatchers(io = Dispatchers.IO, main = Dispatchers.Main) }
  single(named("io")) { ioDispatcher(get()) }
}

private fun ioDispatcher(dispatchers: CoroutineDispatchers): CoroutineDispatcher {
  return dispatchers.io
}
