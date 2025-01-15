// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.players.data

interface PlayerRepository {
  suspend fun getAllPlayers(teamId: Int): Result<List<PlayerEntity>>
}
