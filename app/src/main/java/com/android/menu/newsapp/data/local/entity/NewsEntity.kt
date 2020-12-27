package com.android.menu.newsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "link") var link: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
