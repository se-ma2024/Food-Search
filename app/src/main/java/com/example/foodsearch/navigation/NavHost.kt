package com.example.foodsearch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.DetailScreen.DetailScreen
import com.example.foodsearch.SearchResultScreen.SearchResultScreen
import com.example.foodsearch.SearchResultScreen.SearchResultViewModel
import com.example.foodsearch.SearchScreen.SearchScreen
import com.example.foodsearch.SearchScreen.SearchScreenViewModel
import com.example.foodsearch.api.RestaurantRepositoryImpl
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    //ViewModelを作成
    //val searchResultViewModel: SearchResultViewModel = viewModel()
    val searchResultViewModel = SearchResultViewModel()  // 適切な実装に置き換える
    val repository =
        RestaurantRepositoryImpl(searchResultViewModel = searchResultViewModel)  // 適切な実装に置き換える
    val viewModel = SearchScreenViewModel(repository, searchResultViewModel)
    NavHost(navController = navController, startDestination = "SearchScreen") {
        composable(route = "SearchScreen") {
            SearchScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = "SearchResultScreen/{searchWord}") { backStackEntry ->
            val searchWord = backStackEntry.arguments?.getString("searchWord")
            SearchResultScreen(
                SearchWord = searchWord,
                viewModel = searchResultViewModel,
                navController = navController
            )
        }//キーワード入力検索
        composable(route = "SearchResultScreen/{genre}") { backStackEntry ->
            val genre = backStackEntry.arguments?.getString("genre")
            SearchResultScreen(
                SearchWord = genre,
                viewModel = searchResultViewModel,
                navController = navController
            )
        }//ジャンル選択検索
        composable(route = "DetailScreen") {
            // Call DetailScreen with clickRestaurant
            DetailScreen(navController = navController, viewModel = searchResultViewModel)
        }

//レストラン詳細画面遷移
    }
}