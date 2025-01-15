package co.andrethiele.cdl.feature.teams.data

interface TeamRepository {
  suspend fun getTeamById(id: Int): TeamEntity?
  suspend fun getAllTeams(): Result<List<TeamEntity>>
}
