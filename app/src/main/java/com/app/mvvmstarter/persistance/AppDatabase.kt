package com.app.mvvmstarter.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.mvvmstarter.model.Image

@Database(entities = [Image::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loremPicsumDao(): LoremPicsumDao
}