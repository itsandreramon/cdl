package co.andrethiele.cdl.data

import kotlinx.coroutines.CoroutineDispatcher

data class CoroutineDispatchers(val io: CoroutineDispatcher, val main: CoroutineDispatcher)
