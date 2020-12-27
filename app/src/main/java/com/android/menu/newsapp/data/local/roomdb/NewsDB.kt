package com.android.menu.newsapp.data.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.menu.newsapp.data.local.dao.NewsDao
import com.android.menu.newsapp.data.local.entity.NewsEntity

@Database(
    entities = [
        NewsEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class NewsDB : RoomDatabase() {

    abstract fun newsDao(): NewsDao


}