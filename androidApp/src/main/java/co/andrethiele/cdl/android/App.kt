package co.andrethiele.cdl.android

import android.app.Application
import co.andrethiele.cdl.di.initKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}