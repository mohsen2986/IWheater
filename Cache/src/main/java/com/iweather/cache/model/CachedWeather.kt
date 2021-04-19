package com.iweather.cache.model

import androidx.room.Entity

@Entity(tableName = "cached_weather")
data class CachedWeather(
    val temp: Double
)