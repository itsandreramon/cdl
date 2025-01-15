package co.andrethiele.cdl.feature.players.ui.model

import androidx.compose.ui.graphics.Color
import co.andrethiele.cdl.feature.players.data.PlayerEntity
import co.andrethiele.cdl.feature.teams.data.TeamEntity

data class PlayerUiModel(
  val id: Int,
  val name: String,
  val tag: String,
  val avatar: String,
  val teamTint: Color?,
)

fun PlayerEntity.toUiModel(teamEntity: TeamEntity?): PlayerUiModel {
  return PlayerUiModel(
    id = id,
    name = name,
    tag = tag,
    avatar = "files/$avatar",
    teamTint =
      teamEntity?.tintHex?.let {
        val rgb = it.substring(1).toLong(16)
        Color(rgb or 0xFF000000)
      },
  )
}
