package com.pdmcourse.spotlyfe.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.pdmcourse.spotlyfe.ui.navigation.MainNavigation
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.SavedPlacesViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

@Composable
fun AppLayout(viewModel: SavedPlacesViewModel) {
  val navController = rememberNavController()

  MainNavigation(
    navController = navController,
    viewModel = viewModel
  )
}
