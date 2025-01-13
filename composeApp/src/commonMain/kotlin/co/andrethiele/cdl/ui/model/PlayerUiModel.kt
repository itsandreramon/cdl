import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource

data class PlayerUiModel(
    val id: Int,
    val name: String,
    val tag: String,
    val avatar: DrawableResource,
    val teamTint: Color,
)
