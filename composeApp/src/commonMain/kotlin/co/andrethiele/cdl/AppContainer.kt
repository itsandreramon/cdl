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
import androidx.navigation.compose.rememberNavController
import co.andrethiele.cdl.nav.NavContainer
import co.andrethiele.cdl.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun AppContainer() {
  KoinContext { AppTheme { AppContent() } }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun AppContent() {
  val navController = rememberNavController()

  Scaffold(
    topBar = {
      CenterAlignedTopAppBar(
        title = { Text(text = "Home", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center) }
      )
    },
    content = { padding -> Box(Modifier.padding(padding)) { NavContainer(navController) } },
  )
}
