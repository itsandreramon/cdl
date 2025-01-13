package co.andrethiele.cdl.data.team

interface TeamRepository {
  suspend fun getTeamById(id: Int): Team?
}
