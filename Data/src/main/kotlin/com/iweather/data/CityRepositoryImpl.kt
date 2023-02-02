package com.iweather.data

import com.iweather.data.mapper.EntityMapper
import com.iweather.data.model.CityEntity
import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.weather.WeatherCache
import com.iweather.data.source.city.CityDataSourceFactory
import com.iweather.domain.base.DataHolder
import com.iweather.domain.base.Success
import com.iweather.domain.base.map
import com.iweather.domain.models.City
import com.iweather.domain.repositories.CityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CityRepositoryImpl (
    private val mapper: EntityMapper<CityEntity, City>,
    private val factory: CityDataSourceFactory
): CityRepository{
    override suspend fun searchCity(name: String): Flow<DataHolder<List<City>>> {
        return factory.getRemoteDataSource().searchCityByName(name).map {
            it.map {
                it.map {
                    mapper.mapFromEntity(it)
                }
            }
        }
    }
}