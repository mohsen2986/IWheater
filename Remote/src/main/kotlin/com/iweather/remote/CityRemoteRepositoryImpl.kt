package com.iweather.remote

import com.iweather.data.model.CityEntity
import com.iweather.data.repository.city.CityRemote
import com.iweather.domain.base.DataHolder
import com.iweather.domain.base.Success
import com.iweather.remote.mapper.ModelMapper
import com.iweather.remote.model.SearchCityDto
import com.iweather.remote.model.SearchCityDtoList
import com.iweather.remote.service.ApiInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CityRemoteRepositoryImpl(
    private val service: ApiInterface,
    private val mapper2: ModelMapper<SearchCityDto, CityEntity>
): CityRemote {
    override suspend fun searchCityByName(cityName: String): Flow<DataHolder<List<CityEntity>>> =
        flow{
            val data: SearchCityDtoList = service.searchCityByName(cityName)
            emit(Success(
                data.map { mapper2.mapFromModel(it) }
            ))
        }
}