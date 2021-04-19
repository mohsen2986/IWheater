package com.iweather.cache

import com.iweather.cache.db.WeatherDatabase
import com.iweather.cache.mapper.CachedWeatherMapper
import com.iweather.cache.model.DatabaseStatus
import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.WeatherCache
import com.iweather.domain.base.Result
import com.iweather.domain.base.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class WeatherCacheRepositoryImpl(
    private val weatherDatabase: WeatherDatabase ,
    private val mapper: CachedWeatherMapper
):WeatherCache{
    override suspend fun getWeather(): Flow<Result<WeatherEntity>> =
        weatherDatabase.cachedWeatherDao().getWeather().map { list -> Success(mapper.mapFromCached(list[0])) }


    override suspend fun setLastCacheTime() =
        weatherDatabase.cachedStatusDao()
            .upsetStatus(DatabaseStatus(lastCache = System.currentTimeMillis()))


    override suspend fun isWeatherCacheExpired(): Flow<Boolean> {
        val currentTime = System.currentTimeMillis()
        val expirationTime = (60 * 10 * 1000).toLong()
        return weatherDatabase.
                cachedStatusDao().getStatus()
                .catch {  DatabaseStatus( lastCache =0 )}
                .map { currentTime - it.lastCache > expirationTime }
    }

    override suspend fun setWeather(weatherEntity: WeatherEntity) =
        weatherDatabase.cachedWeatherDao().upsetWeather(mapper.mapToCached(weatherEntity)) as Unit




}