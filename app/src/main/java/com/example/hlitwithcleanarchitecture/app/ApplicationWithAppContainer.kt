package com.example.hlitwithcleanarchitecture.app

import android.app.Application
import android.content.Context
import com.example.hlitwithcleanarchitecture.manual.AppContainer

class ApplicationWithAppContainer: Application() {

    private lateinit var context: Context
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        appContainer = AppContainer(context = context)
    }
}