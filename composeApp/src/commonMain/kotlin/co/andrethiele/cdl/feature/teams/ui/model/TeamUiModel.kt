// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.teams.ui.model

import androidx.compose.ui.graphics.Color
import co.andrethiele.cdl.feature.teams.data.TeamEntity
import co.andrethiele.cdl.util.toColor

data class TeamUiModel(val id: Int, val name: String, val tint: Color, val logoPath: String)

fun TeamEntity.toUiModel(): TeamUiModel {
  return TeamUiModel(
    id = id,
    name = name,
    tint = tintHex.toColor(),
    logoPath = "files/img/teams/$logo",
  )
}
