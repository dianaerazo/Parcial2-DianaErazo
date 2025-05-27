package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.*
import com.google.maps.android.compose.*
import com.pdmcourse.spotlyfe.data.model.Place
import com.pdmcourse.spotlyfe.ui.layout.CustomFloatingButton
import com.pdmcourse.spotlyfe.ui.layout.CustomTopBar

@Composable
fun SavedPlacesScreen(
  viewModel: SavedPlacesViewModel,
  onAddPlaceClick: () -> Unit
) {
  val places by viewModel.places.collectAsState()
  val cameraPositionState = rememberCameraPositionState {
    position = CameraPosition.fromLatLngZoom(
      LatLng(13.6929, -89.2182), 12f
    )
  }

  var uiSettings by remember {
    mutableStateOf(MapUiSettings(zoomControlsEnabled = false))
  }
  var properties by remember {
    mutableStateOf(MapProperties(mapType = MapType.HYBRID))
  }

  Scaffold(
    topBar = { CustomTopBar() },
    floatingActionButton = {
      CustomFloatingButton(onClick = onAddPlaceClick)
    }
  ) { paddingValues ->
    Column(modifier = Modifier.padding(paddingValues)) {
      GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings
      ) {
        places.forEach { place ->
          Marker(
            state = MarkerState(position = LatLng(place.latitude, place.longitude)),
            title = place.name,
            snippet = place.remark
          )
        }
      }
    }
  }
}
