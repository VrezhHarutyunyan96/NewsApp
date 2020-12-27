package com.android.menu.newsapp.di

import org.koin.core.KoinApplication

import android.content.Context
import androidx.room.Room
import com.android.menu.newsapp.data.local.roomdb.NewsDB
import com.android.menu.newsapp.ui.home.viewmodel.NewsViewModel
import com.android.menu.newsapp.ui.home.viewmodel.SavedNewsViewModel
import com.android.menu.newsapp.ui.home.viewmodel.repository.DataBaseRepository
import com.android.menu.newsapp.ui.home.viewmodel.repository.NewsRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

/** class for dependency injection, working with  Koin library **/

object DI {
    private lateinit var koinApp: KoinApplication

    fun init(appContext: Context) {
        koinApp = startKoin {
            androidLogger()
            androidContext(appContext)
            modules(
                dataModule(appContext),
                presentationModule(appContext),
            )
        }
    }

    private fun dataModule(appContext: Context) = module {
        single { NewsRepositoryImpl() }
        single {
            Room.databaseBuilder(appContext, NewsDB::class.java, "news_database")
                .build()
        }
        single { get<NewsDB>().newsDao() }

        single { DataBaseRepository(newsDao = get()) }
    }

    private fun presentationModule(appContext: Context) = module {
        viewModel { NewsViewModel(get() as NewsRepositoryImpl) }
        viewModel { SavedNewsViewModel(get()) }
    }

}