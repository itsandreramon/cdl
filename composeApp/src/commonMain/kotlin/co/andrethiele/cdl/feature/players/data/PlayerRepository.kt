package co.andrethiele.cdl.feature.players.data

interface PlayerRepository {
  suspend fun getAllPlayers(): Result<List<PlayerEntity>>
}
