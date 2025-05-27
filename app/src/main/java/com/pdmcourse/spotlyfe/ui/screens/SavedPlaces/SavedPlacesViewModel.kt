package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdmcourse.spotlyfe.data.Repository.PlaceRepository
import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SavedPlacesViewModel(private val repository: PlaceRepository) : ViewModel() {
    val places: StateFlow<List<Place>> = repository.getPlaces()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addPlace(place: Place) {
        viewModelScope.launch {
            repository.addPlace(place)
        }
    }
}

