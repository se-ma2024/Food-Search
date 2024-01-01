package com.example.foodsearch.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodsearch.DetailScreen.DetailScreen
import com.example.foodsearch.SearchResultScreen.SearchResultScreen
import com.example.foodsearch.SearchResultScreen.SearchResultViewModel
import com.example.foodsearch.SearchScreen.SearchScreen
import com.example.foodsearch.SearchScreen.SearchScreenViewModel

@Composable
fun MainNavHost(){
    val navController = rememberNavController()

    //ViewModelを作成
    val searchResultViewModel: SearchResultViewModel = viewModel()
    val viewModel = SearchScreenViewModel()
    NavHost(navController = navController, startDestination = "SearchScreen"){
        composable(route = "SearchScreen"){
            SearchScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = "SearchResultScreen/{searchWord}"){ backStackEntry ->
            val searchWord = backStackEntry.arguments?.getString("searchWord")
            SearchResultScreen(SearchWord = searchWord, viewModel = searchResultViewModel, navController = navController)
        }//キーワード入力検索
        composable(route = "SearchResultScreen/{genre}"){ backStackEntry ->
            val genre = backStackEntry.arguments?.getString("genre")
            SearchResultScreen(SearchWord = genre, viewModel = searchResultViewModel, navController = navController)
        }//ジャンル選択検索
        composable(
            route = "DetailScreen/{restaurantId}",
            arguments = listOf(
                navArgument("restaurantId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            // Extract the restaurantId from the arguments
            val restaurantId: Int? = backStackEntry.arguments?.getInt("restaurantId")
            // Replace the content with your actual DetailScreen composable
            DetailScreen(restaurantId = restaurantId, navController = navController)
        }//レストラン詳細画面遷移
    }
}