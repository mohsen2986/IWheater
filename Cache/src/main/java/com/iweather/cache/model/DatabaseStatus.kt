package com.iweather.cache.model

import androidx.room.Entity

@Entity(tableName = "database_status")
data class DatabaseStatus(
    val id: Int = -1 ,
    val lastCache: Long
)