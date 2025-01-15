package co.andrethiele.cdl.feature.players.data

interface PlayerRepository {
  suspend fun getAllPlayers(teamId: Int): Result<List<PlayerEntity>>
}
