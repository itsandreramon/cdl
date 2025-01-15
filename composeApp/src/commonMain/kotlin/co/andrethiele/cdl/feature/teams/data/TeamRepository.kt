package co.andrethiele.cdl.feature.teams.data

interface TeamRepository {
  suspend fun getTeamById(id: Int): Team?
}
