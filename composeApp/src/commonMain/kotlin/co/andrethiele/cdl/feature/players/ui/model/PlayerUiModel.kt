package co.andrethiele.cdl.feature.players.ui.model

import androidx.compose.ui.graphics.Color
import co.andrethiele.cdl.feature.players.data.PlayerEntity

data class PlayerUiModel(
  val id: Int,
  val name: String,
  val tag: String,
  val avatar: String,
  val teamTint: Color,
)

fun PlayerEntity.toUiModel(teamTint: Color): PlayerUiModel {
  return PlayerUiModel(
    id = id,
    name = name,
    tag = tag,
    avatar = "files/$avatar",
    teamTint = teamTint,
  )
}
