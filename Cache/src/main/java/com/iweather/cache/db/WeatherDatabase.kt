package com.iweather.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iweather.cache.dao.CachedWeatherDao
import com.iweather.cache.dao.DatabaseStatusDao
import com.iweather.cache.model.CachedWeather
import com.iweather.cache.model.DatabaseStatus
import com.iweather.cache.model.SingletonHolder

@Database(
    entities = [
        CachedWeather::class ,
        DatabaseStatus::class
    ] ,
    version = 1 ,
    exportSchema = false
)
abstract class WeatherDatabase(
): RoomDatabase() {

    abstract fun cachedWeatherDao(): CachedWeatherDao
    abstract fun cachedStatusDao(): DatabaseStatusDao

    companion object : SingletonHolder<Context, WeatherDatabase>({
        Room.databaseBuilder(
            it.applicationContext,
            WeatherDatabase::class.java,
            "weather.db"
        ).build()
    })


}