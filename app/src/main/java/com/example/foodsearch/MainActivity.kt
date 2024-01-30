package com.example.foodsearch

import LocationSensor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.foodsearch.navigation.MainNavHost
import com.example.foodsearch.ui.theme.FoodSearchTheme

class MainActivity : ComponentActivity() {

    private lateinit var locationSensor: LocationSensor
    private var locationPermissionGranted by mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize LocationSensor
        locationSensor = LocationSensor(this)

        setContent {
            FoodSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Check and request location permission
                    if (locationPermissionGranted || checkLocationPermission()) {
                        // Permission granted or already granted
                        locationPermissionGranted = true
                        locationSensor.startLocationUpdates()
                    } else {
                        // Permission not granted, request it
                        requestLocationPermission.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
                    }

                    // MainNavHost with locationSensor passed to composable
                    MainNavHost(locationSensor)
                }
            }
        }
    }

    // Check location permission
    private fun checkLocationPermission(): Boolean {
        return checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED
    }

    // Request location permission using the ActivityResultContracts.RequestPermission contract
    private val requestLocationPermission = registerForActivityResult(
        androidx.activity.result.contract.ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        locationPermissionGranted = isGranted
        if (isGranted) {
            locationSensor.startLocationUpdates()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop location updates when the activity is destroyed
        locationSensor.stopLocationUpdates()
    }
}