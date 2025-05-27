package com.pdmcourse.spotlyfe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pdmcourse.spotlyfe.data.Repository.PlaceRepository
import com.pdmcourse.spotlyfe.data.database.AppDatabase
import com.pdmcourse.spotlyfe.ui.AppLayout
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.SavedPlacesViewModel
import com.pdmcourse.spotlyfe.ui.theme.SpotLyfeTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val db = AppDatabase.getDatabase(applicationContext)
    val repo = PlaceRepository(db.placeDao())
    val savedPlacesViewModel = SavedPlacesViewModel(repo)

    setContent {
      SpotLyfeTheme {
        AppLayout(savedPlacesViewModel)
      }
    }
  }
}
