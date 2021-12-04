package com.example.cocktailmvvmcoroutine

import android.app.Application
import android.content.Context
import android.os.StrictMode
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class CocktailApplication : Application() {
    override fun onCreate() {
        instance = this

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .build()
            )
        }

        Timber.plant(Timber.DebugTree())
        super.onCreate()
    }

    companion object {
        private lateinit var instance : CocktailApplication
        fun getApplicationContext(): Context? {
            return instance.applicationContext
        }
    }
}
