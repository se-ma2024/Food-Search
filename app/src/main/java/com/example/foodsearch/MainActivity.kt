package com.example.foodsearch

import LocationSensor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.foodsearch.navigation.MainNavHost
import com.example.foodsearch.ui.theme.FoodSearchTheme

class MainActivity : ComponentActivity() {

    private lateinit var locationSensor: LocationSensor
    private var locationPermissionGranted by mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locationSensor = LocationSensor(this)

        setContent {
            FoodSearchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (locationPermissionGranted || checkLocationPermission()) {
                        locationPermissionGranted = true
                        locationSensor.startLocationUpdates()
                    } else {
                        requestLocationPermission.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
                    }
                    MainNavHost(locationSensor)
                }
            }
        }
    }

    private fun checkLocationPermission(): Boolean {
        return checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED
    }

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
        locationSensor.stopLocationUpdates()
    }
}