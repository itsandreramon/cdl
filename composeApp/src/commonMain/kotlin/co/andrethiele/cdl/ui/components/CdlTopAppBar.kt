// Copyright 2025 - André Thiele

package co.andrethiele.cdl.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import cdl.composeapp.generated.resources.Res
import cdl.composeapp.generated.resources.a11y_back
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CdlTopAppBar(title: String, onBackClicked: (() -> Unit)? = null) {
  CenterAlignedTopAppBar(
    title = { Text(text = title, fontWeight = FontWeight.Bold) },
    navigationIcon = {
      if (onBackClicked != null) {
        IconButton(onClick = onBackClicked) {
          Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(Res.string.a11y_back),
          )
        }
      }
    },
  )
}
