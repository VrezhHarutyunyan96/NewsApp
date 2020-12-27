package com.android.menu.newsapp.ui.home.viewmodel.repository

import com.android.menu.newsapp.ui.home.model.NewsResponseWrapper
import retrofit2.Response

interface NewsRepository {
    suspend fun getNews(): Response<NewsResponseWrapper>
}