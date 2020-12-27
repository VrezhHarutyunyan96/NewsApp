package com.android.menu.newsapp.helper

import okhttp3.ResponseBody

class Helper {

    companion object {

        inline fun <reified T : Any?> errorBodyToObject(responseBody: ResponseBody?): T? {
            responseBody?.let {
//            TODO show error
                return null
            } ?: run {
                return null
            }
        }

    }
}