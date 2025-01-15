// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.players.ui.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import co.andrethiele.cdl.feature.players.ui.model.PlayerUiModel

@Composable
fun PlayerCards(padding: Dp, players: List<PlayerUiModel>) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    contentPadding = PaddingValues(padding),
    horizontalArrangement = Arrangement.spacedBy(padding),
    verticalArrangement = Arrangement.spacedBy(padding),
    modifier = Modifier.fillMaxSize(),
  ) {
    items(players) { PlayerCard(it) }
  }
}
