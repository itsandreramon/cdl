// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.stats.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import co.andrethiele.cdl.feature.players.data.PlayerRepository
import co.andrethiele.cdl.feature.players.ui.model.PlayerUiModel
import co.andrethiele.cdl.feature.players.ui.model.toUiModel
import co.andrethiele.cdl.feature.teams.data.TeamRepository
import co.andrethiele.cdl.nav.StatsRoute
import co.andrethiele.cdl.ui.components.CdlTopAppBar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

class StatsViewModel(
  private val playerRepository: PlayerRepository,
  private val teamRepository: TeamRepository,
  savedStateHandle: SavedStateHandle,
) : ViewModel() {

  private val route = savedStateHandle.toRoute<StatsRoute>()

  private val _player = MutableStateFlow<PlayerUiModel?>(null)
  val player: StateFlow<PlayerUiModel?> = _player

  fun init() {
    viewModelScope.launch {
      _player.value =
        playerRepository.getPlayerById(route.playerId)?.let {
          val team = teamRepository.getTeamById(it.teamId)
          it.toUiModel(team)
        }
    }
  }
}

@Composable
fun StatsScreen(viewModel: StatsViewModel = koinViewModel(), onBackClicked: () -> Unit) {
  val player by viewModel.player.collectAsStateWithLifecycle()
  LaunchedEffect(Unit) { viewModel.init() }

  player?.let {
    Scaffold(
      topBar = { CdlTopAppBar(title = it.tag, onBackClicked = onBackClicked) },
      content = {
        // TODO
      },
    )
  }
}
