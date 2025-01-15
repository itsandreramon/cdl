package co.andrethiele.cdl.feature.players.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import co.andrethiele.cdl.feature.players.data.PlayerRepository
import co.andrethiele.cdl.feature.players.ui.model.PlayerUiModel
import co.andrethiele.cdl.feature.players.ui.model.toUiModel
import co.andrethiele.cdl.feature.players.ui.screen.components.PlayerCards
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PlayersScreen(viewModel: PlayersViewModel = koinViewModel()) {
  val players by viewModel.players.collectAsStateWithLifecycle()

  LaunchedEffect(Unit) { viewModel.init() }

  PlayerCards(padding = 16.dp, players = players)
}

class PlayersViewModel(private val playerRepository: PlayerRepository) : ViewModel() {

  private val _players = MutableStateFlow<List<PlayerUiModel>>(emptyList())
  val players: StateFlow<List<PlayerUiModel>> = _players

  fun init() {
    viewModelScope.launch {
      playerRepository.getAllPlayers().onSuccess { players ->
        _players.value = players.map { it.toUiModel(Color.Black) }
      }
    }
  }
}
