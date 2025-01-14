package co.andrethiele.cdl.data.player

import kotlinx.serialization.Serializable

@Serializable
data class PlayerEntity(val id: Int, val name: String, val tag: String, val avatar: String, val team: Int)
