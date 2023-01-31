package com.iweather.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.iweather.cache.db.DatabaseStatusConstants

@Entity(tableName = DatabaseStatusConstants.TABLE_NAME)
data class DatabaseStatus(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 1 ,
    val lastCache: Long
)