package com.iweather.domain.repositories

import com.iweather.domain.base.DataHolder
import com.iweather.domain.models.City
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    suspend fun searchCity(name: String): Flow<DataHolder<List<City>>>
}