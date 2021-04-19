package com.iweather.cache.dao

import androidx.room.*
import com.iweather.cache.db.DatabaseStatusConstants
import com.iweather.cache.model.DatabaseStatus
import kotlinx.coroutines.flow.Flow

@Dao
abstract class DatabaseStatusDao{

    @Query(DatabaseStatusConstants.QUERY_STATUS)
    abstract fun getStatus(): Flow<DatabaseStatus>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun upsetStatus(databaseStatus: DatabaseStatus)

}