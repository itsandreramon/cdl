// Copyright 2025 - André Thiele

package co.andrethiele.cdl.util

import kotlinx.coroutines.CancellationException

/**
 * Equivalent to runCatching but automatically rethrows CancellationException.
 *
 * @param block The suspend block to run.
 */
inline fun <T> runSuspendCatching(block: () -> T): Result<T> {
  return try {
    Result.success(block())
  } catch (e: CancellationException) {
    throw e
  } catch (e: Exception) {
    Result.failure(e)
  }
}
