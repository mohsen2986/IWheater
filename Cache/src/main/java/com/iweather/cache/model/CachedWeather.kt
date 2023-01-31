package com.iweather.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.iweather.cache.db.WeatherConstants

@Entity(tableName = WeatherConstants.TABLE_NAME)
data class CachedWeather(
    val temp: Double ,
    @PrimaryKey(autoGenerate = false)
    val id: Int =1
)