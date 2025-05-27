package com.pdmcourse.spotlyfe.ui.screens.AddPlace

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.pdmcourse.spotlyfe.data.model.Place
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.SavedPlacesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlaceScreen(
    viewModel: SavedPlacesViewModel,
    onBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedLatLng by remember { mutableStateOf<LatLng?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agregar lugar") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (name.isNotBlank() && selectedLatLng != null) {
                        viewModel.addPlace(
                            Place(
                                name = name,
                                remark = description,
                                latitude = selectedLatLng!!.latitude,
                                longitude = selectedLatLng!!.longitude
                            )
                        )
                        onBack()
                    }
                }
            ) {
                Icon(Icons.Default.Save, contentDescription = "Guardar")
            }
        }
            ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre del lugar") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción (opcional)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Toca el mapa para seleccionar la ubicación")

            SelectLocationMap(
                initialPosition = selectedLatLng ?: LatLng(13.6929, -89.2182),
                onLocationChanged = { latLng -> selectedLatLng = latLng }
            )
        }
        }
    }

