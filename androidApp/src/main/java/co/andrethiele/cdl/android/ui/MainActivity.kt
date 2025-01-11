package co.andrethiele.cdl.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.andrethiele.cdl.Greeting
import co.andrethiele.cdl.android.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          GreetingView(Greeting().greet())
        }
      }
    }
  }
}

@Composable
fun GreetingView(text: String, modifier: Modifier = Modifier) {
  Text(text = text)
}

@Preview
@Composable
private fun DefaultPreview() {
  MyApplicationTheme { GreetingView("Hello, Android!") }
}
