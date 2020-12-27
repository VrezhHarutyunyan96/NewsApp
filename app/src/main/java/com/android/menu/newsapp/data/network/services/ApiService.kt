package com.android.menu.newsapp.data.network.services

import com.android.menu.newsapp.ui.home.model.NewsResponseWrapper
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("rss/")
    suspend fun getNews(): Response<NewsResponseWrapper>
}