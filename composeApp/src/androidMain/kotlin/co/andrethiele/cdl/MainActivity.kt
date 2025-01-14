package co.andrethiele.cdl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import co.andrethiele.cdl.di.commonModule
import org.koin.compose.KoinApplication

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      KoinApplication(application = {
        modules(commonModule())
      }) {
        App()
      }
    }
  }
}

@Preview
@Composable
private fun AppPreview() {
  App()
}
