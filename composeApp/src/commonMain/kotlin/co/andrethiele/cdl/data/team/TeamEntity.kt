package co.andrethiele.cdl.data.team

import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: Int,
    val name: String,
    val tint: String,
)