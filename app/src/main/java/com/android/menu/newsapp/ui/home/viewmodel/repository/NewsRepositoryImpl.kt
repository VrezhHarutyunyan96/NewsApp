package com.android.menu.newsapp.ui.home.viewmodel.repository

import com.android.menu.newsapp.data.network.RetrofitClient
import com.android.menu.newsapp.data.network.services.ApiService
import com.android.menu.newsapp.ui.home.model.NewsResponseWrapper
import retrofit2.Response

class NewsRepositoryImpl: NewsRepository {
    override suspend fun getNews(): Response<NewsResponseWrapper> {
       return RetrofitClient.instance?.createService(ApiService::class.java)?.getNews()!!
    }
}