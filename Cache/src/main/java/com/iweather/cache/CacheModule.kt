package com.iweather.cache

import com.iweather.cache.db.WeatherDatabase
import com.iweather.cache.mapper.CachedWeatherMapper
import com.iweather.data.repository.WeatherCache
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val cacheModule = Kodein.Module(name = "CacheModule") {
    bind() from singleton { CachedWeatherMapper() }
    bind() from singleton { WeatherDatabase.getInstance(instance())}    /// get room instance

    bind<WeatherCache>() with singleton { WeatherCacheRepositoryImpl(instance() , instance()) }
}