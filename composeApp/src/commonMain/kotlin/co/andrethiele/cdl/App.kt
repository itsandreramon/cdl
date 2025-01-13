package co.andrethiele.cdl

import PlayerUiModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cdl.composeapp.generated.resources.Res
import cdl.composeapp.generated.resources.abezy
import cdl.composeapp.generated.resources.shotzzy
import co.andrethiele.cdl.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
  AppTheme {
    Scaffold(
      topBar = {
        CenterAlignedTopAppBar(
          title = {
            Text(
              text = "Players",
              fontWeight = FontWeight.Bold,
              textAlign = TextAlign.Center,
            )
          },
        )
      },
      content = { padding ->
        Box(Modifier.padding(padding)) {
          HomeScreen()
        }
      }
    )
  }
}

@Composable
private fun HomeScreen() {
  PlayerCards(
    padding = 16.dp,
    players = listOf(
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
    )
  )
}

@Composable
private fun PlayerCards(padding: Dp, players: List<PlayerUiModel>) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    contentPadding = PaddingValues(padding),
    horizontalArrangement = Arrangement.spacedBy(padding),
    verticalArrangement = Arrangement.spacedBy(padding),
    modifier = Modifier.fillMaxSize(),
  ) {
    items(players) {
      PlayerCard(it)
    }
  }
}

@Composable
private fun PlayerCard(
  model: PlayerUiModel,
  modifier: Modifier = Modifier,
  onClick: () -> Unit = {},
) {
  Box(modifier = modifier) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .clip(RoundedCornerShape(16.dp))
        .clickable { onClick() }
    ) {
      Image(
        painter = painterResource(model.avatar),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
      )

      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(
            brush = Brush.verticalGradient(
              colors = listOf(Color.Transparent, model.teamTint.copy(alpha = .5f)),
              startY = 0f,
              endY = Float.POSITIVE_INFINITY
            )
          )
      )

      Text(
        text = model.tag,
        modifier = Modifier
          .align(Alignment.BottomCenter)
          .padding(16.dp),
        color = Color.White,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleLarge
      )
    }
  }
}