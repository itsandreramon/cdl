// Copyright 2025 - André Thiele

package co.andrethiele.cdl

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import co.andrethiele.cdl.nav.NavContainer
import co.andrethiele.cdl.ui.theme.AppTheme
import org.koin.compose.KoinContext

@Composable
fun AppContainer() {
  KoinContext { AppTheme { AppContent() } }
}

@Composable
private fun AppContent() {
  val navController = rememberNavController()
  NavContainer(navController)
}
