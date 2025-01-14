package co.andrethiele.cdl.di

import co.andrethiele.cdl.data.player.PlayerRepository
import co.andrethiele.cdl.data.player.PlayerRepositoryImpl
import co.andrethiele.cdl.ui.screen.players.PlayersViewModel
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect fun platformModule(): Module

fun commonModule() = module {
  single { Json { ignoreUnknownKeys = true } }
  singleOf(::PlayerRepositoryImpl) bind PlayerRepository::class
  viewModelOf(::PlayersViewModel)
}
