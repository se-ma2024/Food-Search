package com.example.foodsearch.navigation

import LocationSensor
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodsearch.DetailScreen.DetailScreen
import com.example.foodsearch.SearchResultScreen.SearchResultScreen
import com.example.foodsearch.SearchResultScreen.SearchResultViewModel
import com.example.foodsearch.SearchScreen.SearchScreen
import com.example.foodsearch.SearchScreen.SearchScreenViewModel
import com.example.foodsearch.api.RestaurantRepositoryImpl

@Composable
fun MainNavHost(locationSensor: LocationSensor) {
    val navController = rememberNavController()

    val searchResultViewModel = SearchResultViewModel()
    val repository = RestaurantRepositoryImpl(searchResultViewModel = searchResultViewModel)
    val viewModel = SearchScreenViewModel(repository, searchResultViewModel)

    NavHost(navController = navController, startDestination = "SearchScreen") {
        composable(route = "SearchScreen") {
            SearchScreen(
                navController = navController,
                viewModel = viewModel,
                locationSensor = locationSensor
            )
        }
        composable(route = "SearchResultScreen/{searchWord}") { backStackEntry ->
            val searchWord = backStackEntry.arguments?.getString("searchWord")
            SearchResultScreen(
                SearchWord = searchWord,
                viewModel = searchResultViewModel,
                navController = navController
            )
        }
        composable(route = "SearchResultScreen/{genre}") { backStackEntry ->
            val genre = backStackEntry.arguments?.getString("genre")
            SearchResultScreen(
                SearchWord = genre,
                viewModel = searchResultViewModel,
                navController = navController
            )
        }
        composable(route = "DetailScreen") {
            DetailScreen(navController = navController, viewModel = searchResultViewModel)
        }
    }
}