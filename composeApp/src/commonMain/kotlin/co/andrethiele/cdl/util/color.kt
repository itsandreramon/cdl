// Copyright 2025 - André Thiele

package co.andrethiele.cdl.util

import androidx.compose.ui.graphics.Color

fun String.toColor(radix: Int = 16): Color {
  val rgb = substring(1).toLong(radix)
  return Color(rgb or 0xFF000000)
}
