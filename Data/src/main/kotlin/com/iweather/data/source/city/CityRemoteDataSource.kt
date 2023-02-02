package com.iweather.data.source.city

import com.iweather.data.model.CityEntity
import com.iweather.data.repository.city.CityDataSource
import com.iweather.data.repository.city.CityRemote
import com.iweather.domain.base.DataHolder
import kotlinx.coroutines.flow.Flow

class CityRemoteDataSource(
    private val cityRemote: CityRemote
): CityDataSource {
    override suspend fun searchCityByName(name: String): Flow<DataHolder<List<CityEntity>>> =
        cityRemote.searchCityByName(name)

    override suspend fun saveCity(city: CityEntity) {
        throw UnsupportedOperationException("saveCity isn't supported here...")
    }
}