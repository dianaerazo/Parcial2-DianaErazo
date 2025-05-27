package com.pdmcourse.spotlyfe.data.database.DAO

import androidx.room.*
import com.pdmcourse.spotlyfe.data.database.entities.PlaceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlace(place: PlaceEntity)

    @Query("SELECT * FROM places")
    fun getAllPlaces(): Flow<List<PlaceEntity>>
}
