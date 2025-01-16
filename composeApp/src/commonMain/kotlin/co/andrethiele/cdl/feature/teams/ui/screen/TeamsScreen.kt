// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.teams.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import cdl.composeapp.generated.resources.Res
import cdl.composeapp.generated.resources.title_teams
import co.andrethiele.cdl.feature.teams.data.TeamRepository
import co.andrethiele.cdl.feature.teams.ui.model.TeamUiModel
import co.andrethiele.cdl.feature.teams.ui.model.toUiModel
import co.andrethiele.cdl.feature.teams.ui.screen.components.TeamCards
import co.andrethiele.cdl.ui.components.CdlTopAppBar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TeamsScreen(viewModel: TeamsViewModel = koinViewModel(), onTeamClicked: (teamId: Int) -> Unit) {
  val teams by viewModel.teams.collectAsStateWithLifecycle()
  LaunchedEffect(Unit) { viewModel.init() }

  Scaffold(
    topBar = { CdlTopAppBar(title = stringResource(Res.string.title_teams)) },
    content = { padding ->
      Box(Modifier.padding(padding)) {
        TeamCards(padding = 16.dp, teams = teams, onTeamClicked = onTeamClicked)
      }
    },
  )
}

class TeamsViewModel(private val teamRepository: TeamRepository) : ViewModel() {

  private val _teams = MutableStateFlow<List<TeamUiModel>>(emptyList())
  val teams: StateFlow<List<TeamUiModel>> = _teams

  fun init() {
    viewModelScope.launch {
      teamRepository.getAllTeams().onSuccess { players ->
        _teams.value = players.map { it.toUiModel() }
      }
    }
  }
}
