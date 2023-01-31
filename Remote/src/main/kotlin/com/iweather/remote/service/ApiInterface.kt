package com.iweather.remote.service

import com.iweather.remote.model.CityWeatherDto
import com.iweather.remote.model.SearchCityDto
import com.iweather.remote.model.SearchCityDtoList
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface{

    @GET("/data/2.5/weather")
    suspend fun getWeatherByCityName(
        @Query("q")
        cityName: String = "Birjand",
        @Query("appid")
        apiKey: String = "e66eeac39bcb454d2218912c1e5b5bf2"
    ): CityWeatherDto


    @GET("geo/1.0/direct")
    suspend fun searchCityByName(
        @Query("q")
        cityName: String = "Birjand",
        @Query("limit")
        limit: Int = 5,
        @Query("appid")
        apiKey: String = "e66eeac39bcb454d2218912c1e5b5bf2"
    ): SearchCityDtoList

}