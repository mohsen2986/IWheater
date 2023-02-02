package com.iweather.cache

import com.iweather.cache.db.WeatherDatabase
import com.iweather.cache.mapper.CachedCityMapper
import com.iweather.data.model.CityEntity
import com.iweather.data.repository.city.CityCache

class CityCacheRepositoryImpl(
    private val weatherDatabase: WeatherDatabase,
    private val mapper: CachedCityMapper
): CityCache {
    // todo implement recent search

    override suspend fun saveCity(city: CityEntity) {
        weatherDatabase.cachedCityDao().save(city = mapper.mapToCached(city))
    }
}