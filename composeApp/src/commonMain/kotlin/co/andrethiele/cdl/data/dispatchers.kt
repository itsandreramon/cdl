// Copyright 2025 - André Thiele

package co.andrethiele.cdl.data

import kotlinx.coroutines.CoroutineDispatcher

data class AppCoroutineDispatchers(
  val io: CoroutineDispatcher,
  val db: CoroutineDispatcher,
  val main: CoroutineDispatcher,
)
