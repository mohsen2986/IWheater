package com.iweather.data.source.weather

import com.iweather.data.repository.weather.WeatherDataSource

open class WeatherDataSourceFactory(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val weatherCacheDataSource: WeatherCacheDataSource,
){
    fun getDataSource(
        isExpired: Boolean ,
        weatherCached: Boolean
    ): WeatherDataSource =
        if(weatherCached && !isExpired)
            weatherCacheDataSource 
        else weatherRemoteDataSource

    fun getCacheDataSource() : WeatherDataSource =
        weatherCacheDataSource


}
