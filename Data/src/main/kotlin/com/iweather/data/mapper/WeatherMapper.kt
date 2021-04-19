package com.iweather.data.mapper

import com.iweather.data.model.WeatherEntity
import com.iweather.domain.models.Weather


class WeatherMapper(
): EntityMapper<WeatherEntity , Weather>{
    override fun mapFromEntity(entity: WeatherEntity): Weather {
        return Weather(entity.temperature)
    }

    override fun mapToEntity(domain: Weather): WeatherEntity {
        return WeatherEntity(domain.temperature)
    }

}