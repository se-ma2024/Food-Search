package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.foodsearch.SearchResultScreen.ResultTopBar
import com.example.foodsearch.SearchResultScreen.SearchResultViewModel

@Composable
fun DetailScreen(navController: NavController, viewModel: SearchResultViewModel) {

    val clickedRestaurant = viewModel.clickedRestaurant

    Column() {
        ResultTopBar(
            SearchWord = clickedRestaurant?.name ?: "店舗名",
            onNavigateUp = {
                navController.navigateUp()
            }
        )
        DetailScreenScrool(clickedRestaurant = clickedRestaurant)
    }
}