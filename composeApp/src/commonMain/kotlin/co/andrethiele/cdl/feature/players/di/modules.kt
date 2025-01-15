package co.andrethiele.cdl.feature.players.di

import co.andrethiele.cdl.feature.players.data.PlayerRepository
import co.andrethiele.cdl.feature.players.data.PlayerRepositoryImpl
import co.andrethiele.cdl.feature.players.ui.screen.PlayersViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val playersModule = module {
  viewModel { PlayersViewModel(get(), get()) }
  single<PlayerRepository> { PlayerRepositoryImpl(get(), get(), get(named("io"))) }
}
