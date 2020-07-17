package com.app.mvvmstarter.di

import androidx.room.Room
import com.app.mvvmstarter.R
import com.app.mvvmstarter.persistance.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room
            .databaseBuilder(
                androidApplication(), AppDatabase::class.java,
                androidApplication().getString(R.string.database)
            )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().loremPicsumDao() }
}