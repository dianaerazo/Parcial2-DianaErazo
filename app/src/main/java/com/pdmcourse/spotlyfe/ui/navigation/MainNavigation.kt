package com.pdmcourse.spotlyfe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pdmcourse.spotlyfe.ui.screens.AddPlace.AddPlaceScreen
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.SavedPlacesScreen
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.SavedPlacesViewModel

const val SavedPlacesRoute  = "saved_places"
const val AddPlaceRoute = "add_place"


@Composable
fun MainNavigation(
  navController: NavHostController,
  viewModel: SavedPlacesViewModel
) {
  NavHost(navController = navController, startDestination = SavedPlacesRoute) {
    composable(SavedPlacesRoute) {
      SavedPlacesScreen(
        viewModel = viewModel,
        onAddPlaceClick = {
          navController.navigate(AddPlaceRoute)
        }
      )
    }
    composable(AddPlaceRoute) {
      AddPlaceScreen(
        viewModel = viewModel,
        onBack = {
          navController.popBackStack()
        }
      )
    }
  }
}

