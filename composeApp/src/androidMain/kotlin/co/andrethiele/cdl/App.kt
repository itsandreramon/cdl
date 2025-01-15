// Copyright 2025 - André Thiele

package co.andrethiele.cdl

import android.app.Application
import co.andrethiele.cdl.di.initKoin
import org.koin.android.ext.koin.androidContext

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    initKoin { androidContext(this@App) }
  }
}
