package co.andrethiele.cdl.feature.teams.data

import kotlinx.serialization.Serializable

@Serializable data class Team(val id: Int, val name: String, val tint: String)
