package co.andrethiele.cdl

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.andrethiele.cdl.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
  AppTheme {
    Scaffold(
      topBar = {
        TopAppBar(title = { Text("Call of Duty League") })
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
  Column(modifier = Modifier.padding(16.dp)) {
    Text("Shotzzy")
    Text("aBeZy")
  }
}
