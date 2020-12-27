package com.android.menu.newsapp.ui.home.viewmodel.repository

import com.android.menu.newsapp.data.local.dao.NewsDao
import com.android.menu.newsapp.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

class DataBaseRepository(
    private val newsDao: NewsDao
) {
    val getSavedNewsData: Flow<List<NewsEntity>>
        get() = newsDao.getSavedData()

    suspend fun add(newsEntity: NewsEntity) {
        newsDao.save(newsEntity)
    }

}