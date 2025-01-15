package co.andrethiele.cdl.di

import android.content.Context
import co.andrethiele.cdl.App
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

actual val platformModule = module { single { appCoroutineScope(get()) } }

private fun appCoroutineScope(context: Context): CoroutineScope {
  return (context as App).coroutineScope
}
