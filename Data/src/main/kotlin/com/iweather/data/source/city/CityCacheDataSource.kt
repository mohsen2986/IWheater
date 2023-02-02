package com.iweather.data.source.city

import com.iweather.data.model.CityEntity
import com.iweather.data.repository.city.CityCache
import com.iweather.data.repository.city.CityDataSource
import com.iweather.domain.base.DataHolder
import kotlinx.coroutines.flow.Flow

class CityCacheDataSource(
    private val cityCache: CityCache
): CityDataSource {
    override suspend fun searchCityByName(name: String): Flow<DataHolder<List<CityEntity>>> {
        throw UnsupportedOperationException("searchCity isn't supported here...")
    }

    override suspend fun saveCity(city: CityEntity) {
        cityCache.saveCity(city)
    }
}