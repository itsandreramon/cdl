package co.andrethiele.cdl.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import co.andrethiele.cdl.android.ui.theme.AppTheme
import coil3.compose.AsyncImage

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AppTheme {
        Scaffold(
          topBar = { TopAppBar(title = { Text("Call of Duty League", fontWeight = FontWeight.Bold) }) },
          content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
              AsyncImage(
                model = "",
                contentDescription = null,
              )
            }
          }
        )
      }
    }
  }
}
