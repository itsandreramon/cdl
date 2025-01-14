package co.andrethiele.cdl.ui.screen.players

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import co.andrethiele.cdl.data.player.PlayerRepository
import co.andrethiele.cdl.ui.model.PlayerUiModel
import co.andrethiele.cdl.ui.model.toUiModel
import co.andrethiele.cdl.ui.screen.players.components.PlayerCards
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@Composable
fun PlayersScreen(viewModel: PlayersViewModel = viewModel()) {
  val players by viewModel.players.collectAsStateWithLifecycle()

  LaunchedEffect(Unit) {
    // viewModel.init()
  }

  PlayerCards(
    padding = 16.dp,
    players = players,
  )
}

class PlayersViewModel(
  private val playerRepository: PlayerRepository,
) : ViewModel() {

  private val _players = MutableStateFlow<List<PlayerUiModel>>(emptyList())
  val players: StateFlow<List<PlayerUiModel>> = _players

  fun init() {
    viewModelScope.launch {
      _players.value = playerRepository.getAllPlayers()
        .map { it.toUiModel(Color.Black) }
    }
  }
}