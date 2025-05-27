package com.pdmcourse.spotlyfe.data.Repository

import com.pdmcourse.spotlyfe.data.Mappers.toDomain
import com.pdmcourse.spotlyfe.data.Mappers.toEntity
import com.pdmcourse.spotlyfe.data.database.DAO.PlaceDao
import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlaceRepository(private val dao: PlaceDao) {
    fun getPlaces(): Flow<List<Place>> = dao.getAllPlaces().map { list ->
        list.map { it.toDomain() }
    }

    suspend fun addPlace(place: Place) {
        dao.insertPlace(place.toEntity())
    }
}

