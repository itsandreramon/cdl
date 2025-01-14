package co.andrethiele.cdl.data.player

import co.andrethiele.cdl.resources.ResourceLoader
import kotlinx.serialization.json.Json

class PlayerRepositoryImpl(
  private val json: Json,
  private val resourceLoader: ResourceLoader,
) : PlayerRepository {
  override suspend fun getAllPlayers(): List<PlayerEntity> {
    return resourceLoader.readJsonFromAssets("json/players.json")?.let {
      json.decodeFromString(it)
    } ?: emptyList()
  }
}
