package com.android.menu.newsapp.ui.home.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.menu.newsapp.AppApplication
import com.android.menu.newsapp.helper.Helper
import com.android.menu.newsapp.ui.home.model.NewsItem
import com.android.menu.newsapp.ui.home.model.NewsResponseWrapper
import com.android.menu.newsapp.ui.home.viewmodel.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val mNewsMutableLiveData by lazy {
        return@lazy MutableLiveData<NewsResponseWrapper>()
    }
    private var isChecked = true

    private val mNewsMockMutableLiveData = MutableLiveData<MutableList<NewsItem>>()

    init {
        getNews()
    }

    /** send request every minute **/

    private fun getNews() = viewModelScope.launch {

        do {
            try {
                val response = newsRepository.getNews()

                if (response.isSuccessful) {
                    mNewsMutableLiveData.value = response.body()
                    Toast.makeText(AppApplication.instance, "Data updated", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val model =
                        Helper.errorBodyToObject<NewsResponseWrapper>(response.errorBody())
                    mNewsMutableLiveData.value = model
                }
            } catch (ex: Exception) {
            }

            delay(60000)

        } while (isChecked)

    }

    fun getNewsLiveData(): LiveData<NewsResponseWrapper> =
        mNewsMutableLiveData

    fun getMockNewsLiveData(): LiveData<MutableList<NewsItem>> = mNewsMockMutableLiveData

    /** change data type (mock or real) **/

    fun onDataTypeChanged(isMockType: Boolean) {
        isChecked = !isMockType
        if (isMockType) {
            mNewsMockMutableLiveData.value = mutableListOf(
                NewsItem("test", "test", "test", "test"),
                NewsItem("test", "test", "test", "test")
            )
        } else {
            getNews()
        }
    }
}