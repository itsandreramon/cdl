// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.players.data

import cdl.composeapp.generated.resources.Res
import co.andrethiele.cdl.util.runSuspendCatching
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
class PlayerRepositoryImpl(
  private val json: Json,
  scope: CoroutineScope,
  dispatcher: CoroutineDispatcher,
) : PlayerRepository {

  private val jsonString by lazy {
    scope.async {
      withContext(dispatcher) { Res.readBytes("files/json/players.json").decodeToString() }
    }
  }

  override suspend fun getPlayerById(playerId: Int): PlayerEntity? {
    return getAllPlayers().map { it.find { player -> player.id == playerId } }.getOrNull()
  }

  override suspend fun getAllPlayers(): Result<List<PlayerEntity>> {
    return runSuspendCatching { json.decodeFromString<List<PlayerEntity>>(jsonString.await()) }
  }

  override suspend fun getAllPlayersByTeamId(teamId: Int): Result<List<PlayerEntity>> {
    return getAllPlayers().map { it.filter { player -> player.teamId == teamId } }
  }
}
