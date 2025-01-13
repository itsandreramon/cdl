package co.andrethiele.cdl.data.player

interface PlayerRepository {
    fun getAllPlayers(): List<PlayerEntity>
}