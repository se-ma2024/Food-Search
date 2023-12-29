package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailScreenScrool() {
    LazyColumn() {
        item {
            RestaurantName()
            RestaurantImage()
            RestaurantDetail()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreDetailScreenScrool() {
    DetailScreenScrool()
}