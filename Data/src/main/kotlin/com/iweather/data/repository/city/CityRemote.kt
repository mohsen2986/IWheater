package com.iweather.data.repository.city

import com.iweather.data.model.CityEntity
import com.iweather.domain.base.DataHolder
import kotlinx.coroutines.flow.Flow

interface CityRemote {
    suspend fun searchCityByName(cityName: String): Flow<DataHolder<List<CityEntity>>>
}