package co.andrethiele.cdl.data.player

import kotlinx.serialization.json.Json

class PlayerRepositoryImpl(private val json: Json) : PlayerRepository {
  override fun getAllPlayers(): List<PlayerEntity> {
    return emptyList()
  }
}
