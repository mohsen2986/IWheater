package com.iweather.cache.mapper

import com.iweather.cache.model.CachedCity
import com.iweather.data.model.CityEntity

class CachedCityMapper
    :CacheMapper<CachedCity , CityEntity> {
    override fun mapFromCached(type: CachedCity): CityEntity =
        with(type) {
            CityEntity(name , ""  ,"")
        }

    override fun mapToCached(type: CityEntity): CachedCity =
        with(type){
            CachedCity(name)
        }
}