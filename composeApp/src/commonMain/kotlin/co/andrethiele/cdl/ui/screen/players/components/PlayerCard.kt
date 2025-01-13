package co.andrethiele.cdl.ui.screen.players.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import co.andrethiele.cdl.ui.model.PlayerUiModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun PlayerCard(model: PlayerUiModel, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
  Box(modifier = modifier) {
    Box(
      modifier =
        Modifier.fillMaxWidth().height(300.dp).clip(RoundedCornerShape(16.dp)).clickable {
          onClick()
        }
    ) {
      Image(
        painter = painterResource(model.avatar),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
      )

      Box(
        modifier =
          Modifier.fillMaxSize()
            .background(
              brush =
                Brush.verticalGradient(
                  colors = listOf(Color.Transparent, model.teamTint.copy(alpha = .5f)),
                  startY = 0f,
                  endY = Float.POSITIVE_INFINITY,
                )
            )
      )

      Text(
        text = model.tag,
        modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
        color = Color.White,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleLarge,
      )
    }
  }
}
