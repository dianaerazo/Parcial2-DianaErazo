package com.pdmcourse.spotlyfe.data.Mappers

import com.pdmcourse.spotlyfe.data.database.entities.PlaceEntity
import com.pdmcourse.spotlyfe.data.model.Place

fun PlaceEntity.toDomain(): Place =
    Place(name, remark, latitude,  longitude)

fun Place.toEntity(): PlaceEntity =
    PlaceEntity(0, name, remark, latitude, longitude )


