package com.github.pedroscott.movies_feature.application

import android.app.Application
import com.github.pedroscott.movies_feature.di.AppComponent.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(allModules)
        }
    }
}