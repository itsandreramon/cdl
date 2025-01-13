package co.andrethiele.cdl.ui.screen.players

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cdl.composeapp.generated.resources.Res
import cdl.composeapp.generated.resources.abezy
import cdl.composeapp.generated.resources.shotzzy
import co.andrethiele.cdl.ui.model.PlayerUiModel
import co.andrethiele.cdl.ui.screen.players.components.PlayerCards

@Composable
fun PlayersScreen() {
  PlayerCards(
    padding = 16.dp,
    players =
      listOf(
        PlayerUiModel(
          id = 1,
          tag = "Shotzzy",
          name = "Anthony Cuevas-Castro",
          teamTint = Color(0xFF9CC43D),
          avatar = Res.drawable.shotzzy,
        ),
        PlayerUiModel(
          id = 2,
          tag = "aBeZy",
          name = "Tyler Pharris",
          teamTint = Color(0xFFE43D30),
          avatar = Res.drawable.abezy,
        ),
      ),
  )
}
