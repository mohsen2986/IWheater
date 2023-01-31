package com.iweather.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iweather.cache.db.WeatherConstants
import com.iweather.cache.model.CachedWeather
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CachedWeatherDao {

    @Query(WeatherConstants.QUERY_WEATHER)
    abstract fun getWeather(): Flow<List<CachedWeather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun upsetWeather(weather: CachedWeather): Long

    @Query(WeatherConstants.QUERY_EXISTS)
    abstract fun lastUpdateExist(): Flow<Boolean>
}