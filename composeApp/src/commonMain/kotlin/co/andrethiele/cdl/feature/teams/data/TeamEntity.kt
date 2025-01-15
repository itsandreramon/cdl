package co.andrethiele.cdl.feature.teams.data

import kotlinx.serialization.Serializable

@Serializable
data class TeamEntity(val id: Int, val name: String, val tintHex: String, val logo: String)
