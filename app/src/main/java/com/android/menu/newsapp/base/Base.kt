package com.android.menu.newsapp.base

import android.os.Bundle

interface Base {

    val layoutID: Int

    fun initialize(savedInstanceState: Bundle?) {}
    fun setListeners() {}
}