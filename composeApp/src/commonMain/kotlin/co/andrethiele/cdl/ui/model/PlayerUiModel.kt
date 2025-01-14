package co.andrethiele.cdl.ui.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import cdl.composeapp.generated.resources.Res
import co.andrethiele.cdl.data.player.PlayerEntity
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.decodeToImageBitmap

data class PlayerUiModel(
  val id: Int,
  val name: String,
  val tag: String,
  val avatar: ImageBitmap,
  val teamTint: Color,
)

@OptIn(ExperimentalResourceApi::class)
suspend fun PlayerEntity.toUiModel(teamTint: Color): PlayerUiModel {
  return PlayerUiModel(
    id = id,
    name = name,
    tag = tag,
    avatar = Res.readBytes("files/$avatar").decodeToImageBitmap(),
    teamTint = teamTint,
  )
}
