package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.foodsearch.DataSource.RestaurantInfo

@Composable
fun DetailScreenScrool(clickedRestaurant: RestaurantInfo?) {
    LazyColumn() {
        item {
            RestaurantName(clickedRestaurant = clickedRestaurant)
            RestaurantImage(clickedRestaurant = clickedRestaurant)
            RestaurantDetail(clickedRestaurant = clickedRestaurant)
        }
    }
}