// Copyright 2025 - André Thiele

package co.andrethiele.cdl.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.andrethiele.cdl.AppContainer

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent { AppContainer() }
  }
}
