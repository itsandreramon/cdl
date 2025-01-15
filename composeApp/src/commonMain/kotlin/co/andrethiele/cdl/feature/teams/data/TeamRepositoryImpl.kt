package co.andrethiele.cdl.feature.teams.data

import kotlinx.serialization.json.Json

class TeamRepositoryImpl(private val json: Json) : TeamRepository {
  override suspend fun getTeamById(id: Int): Team? {
    return null
  }
}
