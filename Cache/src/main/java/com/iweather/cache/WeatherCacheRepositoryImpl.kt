package com.iweather.cache

import com.iweather.cache.db.WeatherDatabase
import com.iweather.cache.mapper.CachedWeatherMapper
import com.iweather.cache.model.DatabaseStatus
import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.weather.WeatherCache
import com.iweather.domain.base.DataHolder
import com.iweather.domain.base.Success
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

class WeatherCacheRepositoryImpl(
    private val weatherDatabase: WeatherDatabase ,
    private val mapper: CachedWeatherMapper
): WeatherCache {
    override suspend fun getWeather(): Flow<DataHolder<WeatherEntity>> =
        weatherDatabase.cachedWeatherDao().getWeather().map { list -> Success(mapper.mapFromCached(list[0])) }


    override suspend fun setLastCacheTime() = withContext(IO) {
        weatherDatabase.cachedStatusDao()
                .upsetStatus(DatabaseStatus(lastCache = System.currentTimeMillis()))
    }


    override suspend fun isWeatherCacheExpired(): Flow<Boolean> {
        val currentTime = System.currentTimeMillis()
        val expirationTime = (60 * 10 * 1000).toLong()
        return weatherDatabase.
                cachedStatusDao()
                .getStatus()
                .mapNotNull {
                    return@mapNotNull if (it != null)
                        currentTime - it.lastCache > expirationTime
                    else
                        false
                }

//        return flow { true}
    }

    override suspend fun setWeather(weatherEntity: WeatherEntity) {
        weatherDatabase.cachedWeatherDao().upsetWeather(mapper.mapToCached(weatherEntity))
    }

    override suspend fun isWeatherCached(): Flow<Boolean> =
            weatherDatabase.cachedWeatherDao().getWeather().map {
                it.isNotEmpty()
            }






}