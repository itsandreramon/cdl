package co.andrethiele.cdl

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import co.andrethiele.cdl.feature.players.ui.screen.PlayersScreen
import co.andrethiele.cdl.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun AppContainer() {
  KoinContext {
    AppTheme {
      Scaffold(
        topBar = {
          CenterAlignedTopAppBar(
            title = {
              Text(text = "Players", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            }
          )
        },
        content = { padding -> Box(Modifier.padding(padding)) { PlayersScreen() } },
      )
    }
  }
}
