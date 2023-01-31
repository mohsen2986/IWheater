package com.iweather.data.source.city

import com.iweather.data.repository.city.CityDataSource

class CityDataSourceFactory(
    private val cityCacheDataSource: CityCacheDataSource ,
    private val cityRemoteDataSource: CityRemoteDataSource
) {
    fun getRemoteDataSource(): CityDataSource =
        cityRemoteDataSource
}