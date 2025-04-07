package com.muskan.myapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplicationClass: Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any application-level components here
    }
}