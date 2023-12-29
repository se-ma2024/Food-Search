package com.example.foodsearch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavHost(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SearchScreen"){
        composable(route = ""){

        }
    }
}