package com.iweather.data.repository.city

import com.iweather.data.model.CityEntity

// implement searched cities cache
interface CityCache {
    suspend fun saveCity(city: CityEntity)
}