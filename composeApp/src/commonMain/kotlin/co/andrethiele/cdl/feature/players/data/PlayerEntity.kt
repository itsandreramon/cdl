// Copyright 2025 - André Thiele

package co.andrethiele.cdl.feature.players.data

import kotlinx.serialization.Serializable

@Serializable
data class PlayerEntity(
  val id: Int,
  val name: String,
  val tag: String,
  val avatar: String,
  val teamId: Int,
)
