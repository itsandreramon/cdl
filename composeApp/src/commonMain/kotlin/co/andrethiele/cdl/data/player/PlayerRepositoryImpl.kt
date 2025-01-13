package co.andrethiele.cdl.data.player

import kotlinx.serialization.json.Json

class PlayerRepositoryImpl(private val json: Json) : PlayerRepository {
  override suspend fun getAllPlayers(): List<PlayerEntity> {
    return emptyList()
  }
}
