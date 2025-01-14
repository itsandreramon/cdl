package co.andrethiele.cdl.ui.model

import androidx.compose.ui.graphics.Color
import co.andrethiele.cdl.data.player.PlayerEntity
import org.jetbrains.compose.resources.DrawableResource

data class PlayerUiModel(
  val id: Int,
  val name: String,
  val tag: String,
  val avatar: DrawableResource,
  val teamTint: Color,
)

fun PlayerEntity.toUiModel(teamTint: Color): PlayerUiModel {
  return PlayerUiModel(
    id = id,
    name = name,
    tag = tag,
    avatar = avatar,
    teamTint = teamTint,
  )
}
