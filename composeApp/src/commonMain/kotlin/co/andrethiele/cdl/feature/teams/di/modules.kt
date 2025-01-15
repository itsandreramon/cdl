// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.teams.di

import co.andrethiele.cdl.feature.teams.data.TeamRepository
import co.andrethiele.cdl.feature.teams.data.TeamRepositoryImpl
import co.andrethiele.cdl.feature.teams.ui.screen.TeamsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val teamsModule = module {
  viewModel { TeamsViewModel(get()) }
  single<TeamRepository> { TeamRepositoryImpl(get(), get(), get(named("io"))) }
}
