package com.iweather.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.iweather.cache.model.CachedCity

@Dao
abstract class CachedCityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun save(city: CachedCity)

}