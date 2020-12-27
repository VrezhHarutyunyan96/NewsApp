package com.android.menu.newsapp.utils

import com.android.menu.newsapp.data.local.entity.NewsEntity
import com.android.menu.newsapp.ui.home.model.NewsItem

fun convertModelToEntity(newsItem: NewsItem): NewsEntity {
    val newsEntity = NewsEntity("", "", "")
    return newsEntity.apply {
        date = newsItem.pubDate
        title = newsItem.title
        link = newsItem.link
    }
}