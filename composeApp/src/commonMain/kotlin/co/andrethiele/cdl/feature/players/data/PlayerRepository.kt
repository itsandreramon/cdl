// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.players.data

interface PlayerRepository {
  suspend fun getAllPlayers(): Result<List<PlayerEntity>>

  suspend fun getAllPlayersByTeamId(teamId: Int): Result<List<PlayerEntity>>

  suspend fun getPlayerById(playerId: Int): PlayerEntity?
}
