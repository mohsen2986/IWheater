package com.iweather.remote.mapper

import com.iweather.data.model.CityEntity
import com.iweather.remote.model.SearchCityDto

class SearchCityResponseModelMapper :ModelMapper<SearchCityDto, CityEntity> {
    override fun mapFromModel(model: SearchCityDto): CityEntity =
       with(model){
           CityEntity(name , state ,country)
       }
}