// Copyright 2025 - André Thiele

package co.andrethiele.cdl

import android.app.Application
import co.andrethiele.cdl.di.initKoin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext

class App : Application() {

  val coroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

  override fun onCreate() {
    super.onCreate()
    initKoin { androidContext(this@App) }
  }
}
