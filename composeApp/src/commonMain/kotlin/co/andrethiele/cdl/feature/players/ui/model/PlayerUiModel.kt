package co.andrethiele.cdl.feature.players.ui.model

import androidx.compose.ui.graphics.Color
import co.andrethiele.cdl.feature.players.data.PlayerEntity
import co.andrethiele.cdl.feature.teams.data.TeamEntity
import co.andrethiele.cdl.util.toColor

data class PlayerUiModel(
  val id: Int,
  val name: String,
  val tag: String,
  val avatarPath: String,
  val teamTint: Color?,
)

fun PlayerEntity.toUiModel(teamEntity: TeamEntity?): PlayerUiModel {
  return PlayerUiModel(
    id = id,
    name = name,
    tag = tag,
    avatarPath = "files/img/players/$avatar",
    teamTint = teamEntity?.tintHex?.toColor(),
  )
}
