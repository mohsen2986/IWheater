package com.iweather.cache.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.iweather.cache.db.CityConstants

@Entity(
    tableName = CityConstants.TABLE_NAME ,
    indices = [Index(value = ["name"], unique = true)]
)
data class CachedCity (
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int =1
)