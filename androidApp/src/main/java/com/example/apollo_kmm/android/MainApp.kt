package com.example.apollo_kmm.android

import android.app.Application
import com.example.apollo_kmm.di.initKoin
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}