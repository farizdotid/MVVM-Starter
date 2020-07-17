package com.app.mvvmstarter

import android.app.Application
import com.app.mvvmstarter.di.networkModule
import com.app.mvvmstarter.di.persistenceModule
import com.app.mvvmstarter.di.repositoryModule
import com.app.mvvmstarter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}