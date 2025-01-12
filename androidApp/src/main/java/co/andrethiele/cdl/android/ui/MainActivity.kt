package co.andrethiele.cdl.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.andrethiele.cdl.Greeting
import co.andrethiele.cdl.android.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text("Title") })
                    },
                    content = { padding ->
                        Box(modifier = Modifier.padding(padding)) {
                            GreetingView(text = Greeting().greet())
                        }
                    }
                )
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
    AppTheme { GreetingView("Hello, Android!") }
}
