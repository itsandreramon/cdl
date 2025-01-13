package co.andrethiele.cdl.data.player

interface PlayerRepository {
  suspend fun getAllPlayers(): List<PlayerEntity>
}
