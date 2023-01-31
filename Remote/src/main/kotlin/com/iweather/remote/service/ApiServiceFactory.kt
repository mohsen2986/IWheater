package com.iweather.remote.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiServiceFactory{

    fun createService(): ApiInterface{
        val okhttpClient = createHttpClient()
        return createRetrofitService(okhttpClient)
    }
    private fun createRetrofitService(okHttpClient: OkHttpClient): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiInterface::class.java)
    }

    private fun createHttpClient() =
        OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
//            .addNetworkInterceptor(StethoInterceptor())
            .build()

}