package co.andrethiele.cdl

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
private fun AppContent() {
  val navController = rememberNavController()
  Scaffold { padding -> Box(Modifier.padding(padding)) { NavContainer(navController) } }
}
