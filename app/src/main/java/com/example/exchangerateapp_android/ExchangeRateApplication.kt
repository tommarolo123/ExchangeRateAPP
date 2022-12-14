package com.example.exchangerateapp_android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class ExchangeRateApplication : Application() {
    companion object{
        const val TOKEN = "351b787ddc6f449f804588b85dda17d5"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}