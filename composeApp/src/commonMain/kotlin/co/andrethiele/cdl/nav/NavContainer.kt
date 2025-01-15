// Copyright 2025 - André Thiele

package co.andrethiele.cdl.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.andrethiele.cdl.feature.players.ui.screen.PlayersScreen
import co.andrethiele.cdl.feature.teams.ui.screen.TeamsScreen
import kotlinx.serialization.Serializable

@Serializable object TeamsRoute

@Serializable data class PlayersRoute(val teamId: Int)

@Composable
fun NavContainer(navController: NavHostController) {
  NavHost(navController, startDestination = TeamsRoute) {
    composable<TeamsRoute> {
      TeamsScreen(onTeamClicked = { navController.navigate(PlayersRoute(it)) })
    }

    composable<PlayersRoute> { PlayersScreen(onBackClicked = { navController.popBackStack() }) }
  }
}
