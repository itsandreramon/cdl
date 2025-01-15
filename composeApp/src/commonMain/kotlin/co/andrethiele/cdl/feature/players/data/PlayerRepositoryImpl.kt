package co.andrethiele.cdl.feature.players.data

import cdl.composeapp.generated.resources.Res
import co.andrethiele.cdl.util.runSuspendCatching
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
class PlayerRepositoryImpl(private val json: Json) : PlayerRepository {

  override suspend fun getAllPlayers(): Result<List<PlayerEntity>> {
    return runSuspendCatching {
      readPlayersJson().let { json.decodeFromString(it.decodeToString()) }
    }
  }

  private suspend fun readPlayersJson(): ByteArray {
    return Res.readBytes(PLAYERS_JSON_PATH)
  }

  companion object {
    const val PLAYERS_JSON_PATH = "files/json/players.json"
  }
}
