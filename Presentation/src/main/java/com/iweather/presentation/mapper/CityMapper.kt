package com.iweather.presentation.mapper

import com.iweather.domain.models.City
import com.iweather.presentation.model.CityView

class CityMapper : Mapper< CityView, City>{
    override fun mapToView(type: City): CityView {
        return with(type){
            CityView(type.name)
        }
    }

}