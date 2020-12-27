package com.android.menu.newsapp.data.network

import android.util.Log
import com.android.menu.newsapp.BuildConfig
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.io.IOException
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

/** class for network calls, working with  Retrofit2 library **/

private const val CONNECT_TIME_OUT: Long = 30
private const val READ_TIME_OUT: Long = 30

private const val TAG: String = "adx_network_error"

class RetrofitClient private constructor() {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.RSS_URL)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .client(provideOkHttpClient())
        .build()

//    @Throws(IOException::class)
//    private fun getInterceptor(needToken: Boolean): Interceptor {
//        return object : Interceptor {
//            override fun intercept(chain: Interceptor.Chain): Response {
//                var request: Request = chain.request()
//
//                val locale = ApplicationWrapper.getLocalManager().getCurrentLocale()
//
//                val url: HttpUrl = request.url
//                    .newBuilder()
//                    .addQueryParameter("locale", locale)
//                    .build()
//
//                val requestBuilder = request.newBuilder()
//                if (needToken) {
//                    requestBuilder
//                        .addHeader(
//                            "Authorization",
//                            "Bearer ${ApplicationWrapper.getPreferenceManager().getToken()}"
//                        )
//                }
//                request = requestBuilder
//                    .url(url)
//                    .build()
//
//                val response: Response = chain.proceed(request)
//                if (response.code == 401) {
//                    Log.e(TAG, "OkHttpClient : Unauthorized 401")
//                    ApplicationWrapper.invalidateSession()
//                }
//                return response
//            }
//
//        }
//    }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor(provideHeadersInterceptor())
//            .addInterceptor(ChuckInterceptor(AeonChargeApplication.getContext()))
            .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
            .writeTimeout(60 * 1000, TimeUnit.MILLISECONDS)
            .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
            .build()
    }

//    private fun getOkHttpClient(needToken: Boolean): OkHttpClient {
//
//        val interceptor = HttpLoggingInterceptor()
//
//        if (BuildConfig.DEBUG) {
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//        } else {
//            interceptor.level = HttpLoggingInterceptor.Level.BASIC
//        }
//
//        val okHttpBuilder = OkHttpClient.Builder()
//        try {
//            okHttpBuilder.addInterceptor(interceptor)
//                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
//                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
//                .followRedirects(true)
//                .followSslRedirects(true)
//                .addInterceptor(getInterceptor(needToken))
//        } catch (ex: UnknownHostException) {
//            Log.e(TAG, "OkHttpClient UnknownHostException : " + ex.localizedMessage!!)
//        } catch (ex: IOException) {
//            Log.e(TAG, "OkHttpClient IOException : " + ex.localizedMessage!!)
//        }
//
//        return okHttpBuilder.build()
//    }

    fun <T> createService(interfaceClazz: Class<T>): T {
        return  retrofit.create(
            interfaceClazz
        )
    }

    companion object {
        private var mInstance: RetrofitClient? = null

        @get:Synchronized
        val instance: RetrofitClient?
            get() {
                if (mInstance == null) {
                    mInstance = RetrofitClient()
                }
                return mInstance
            }
    }
}