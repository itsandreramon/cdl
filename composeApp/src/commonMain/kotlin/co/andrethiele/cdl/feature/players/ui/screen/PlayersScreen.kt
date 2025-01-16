// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.players.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import cdl.composeapp.generated.resources.Res
import cdl.composeapp.generated.resources.title_players
import co.andrethiele.cdl.feature.players.data.PlayerRepository
import co.andrethiele.cdl.feature.players.ui.model.PlayerUiModel
import co.andrethiele.cdl.feature.players.ui.model.toUiModel
import co.andrethiele.cdl.feature.players.ui.screen.components.PlayerCards
import co.andrethiele.cdl.feature.teams.data.TeamRepository
import co.andrethiele.cdl.nav.PlayersRoute
import co.andrethiele.cdl.ui.components.CdlTopAppBar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PlayersScreen(
  viewModel: PlayersViewModel = koinViewModel(),
  onBackClicked: () -> Unit,
  onPlayerClicked: (playerId: Int) -> Unit,
) {
  val players by viewModel.players.collectAsStateWithLifecycle()
  LaunchedEffect(Unit) { viewModel.init() }

  Scaffold(
    topBar = {
      CdlTopAppBar(title = stringResource(Res.string.title_players), onBackClicked = onBackClicked)
    },
    content = { padding ->
      Box(Modifier.padding(padding)) {
        PlayerCards(padding = 16.dp, players = players, onPlayerClicked = onPlayerClicked)
      }
    },
  )
}

class PlayersViewModel(
  private val playerRepository: PlayerRepository,
  private val teamRepository: TeamRepository,
  savedStateHandle: SavedStateHandle,
) : ViewModel() {

  private val route = savedStateHandle.toRoute<PlayersRoute>()

  private val _players = MutableStateFlow<List<PlayerUiModel>>(emptyList())
  val players: StateFlow<List<PlayerUiModel>> = _players

  fun init() {
    viewModelScope.launch {
      playerRepository.getAllPlayersByTeamId(route.teamId).onSuccess { players ->
        _players.value =
          players.map {
            val team = teamRepository.getTeamById(it.teamId)
            it.toUiModel(team)
          }
      }
    }
  }
}
