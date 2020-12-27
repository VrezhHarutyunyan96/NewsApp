package com.android.menu.newsapp.ui.home.viewmodel

import androidx.lifecycle.*
import com.android.menu.newsapp.data.local.entity.NewsEntity
import com.android.menu.newsapp.ui.home.model.NewsItem
import com.android.menu.newsapp.ui.home.viewmodel.repository.DataBaseRepository
import com.android.menu.newsapp.utils.convertModelToEntity
import kotlinx.coroutines.launch

class SavedNewsViewModel(private val dataBaseRepository: DataBaseRepository) : ViewModel() {

    /** get saved data from database **/

    val getSavedNews: LiveData<List<NewsEntity>>
        get() {
            return dataBaseRepository.getSavedNewsData.asLiveData()
        }

    /** save news data in room database **/

    fun saveNews(newsItem: NewsItem) = viewModelScope.launch {
        val newsEntity = convertModelToEntity(newsItem)
        dataBaseRepository.add(newsEntity)
    }
}