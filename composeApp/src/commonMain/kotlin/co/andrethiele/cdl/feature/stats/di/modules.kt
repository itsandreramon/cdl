// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.stats.di

import co.andrethiele.cdl.feature.stats.ui.StatsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val statsModule = module { viewModel { StatsViewModel(get(), get(), get()) } }
