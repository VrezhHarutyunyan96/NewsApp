package com.android.menu.newsapp

import android.app.Application
import android.content.Context
import com.android.menu.newsapp.di.DI

/** Application class.
 *  calling first in the app and have app context**/

class AppApplication : Application() {

    init {
        instance = this
    }

    companion object {
        var instance: AppApplication? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        DI.init(this)
    }
}