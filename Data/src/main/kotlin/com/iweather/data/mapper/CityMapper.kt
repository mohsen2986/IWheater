package com.iweather.data.mapper

import com.iweather.data.model.CityEntity
import com.iweather.domain.models.City

class CityMapper(
): EntityMapper<CityEntity , City>{
    override fun mapFromEntity(entity: CityEntity): City {
        return City(entity.name , entity.state  , entity.country)
    }

    override fun mapToEntity(domain: City): CityEntity {
        return CityEntity(domain.name , domain.state , domain.country)
    }

}