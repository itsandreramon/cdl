package co.andrethiele.cdl.feature.teams.data

import cdl.composeapp.generated.resources.Res
import co.andrethiele.cdl.util.runSuspendCatching
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
class TeamRepositoryImpl(
  private val json: Json,
  scope: CoroutineScope,
  dispatcher: CoroutineDispatcher,
) : TeamRepository {

  private val jsonString by lazy {
    scope.async {
      withContext(dispatcher) { Res.readBytes("files/json/teams.json").decodeToString() }
    }
  }

  override suspend fun getTeamById(id: Int): TeamEntity? {
    return runSuspendCatching {
        val teams = json.decodeFromString<List<TeamEntity>>(jsonString.await())
        teams.find { it.id == id }
      }
      .getOrNull()
  }
}
