// Copyright 2025 - André Thiele

package co.andrethiele.cdl.data

import kotlinx.coroutines.CoroutineScope

class AppCoroutineScope(private val parentScope: CoroutineScope) : CoroutineScope by parentScope
