package com.example.foodsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.foodsearch.DetailScreen.DetailScreen
import com.example.foodsearch.SearchResultScreen.SearchResultScreen
import com.example.foodsearch.SearchScreen.SearchScreen
import com.example.foodsearch.navigation.MainNavHost
import com.example.foodsearch.ui.theme.FoodSearchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //SearchScreen()
                    //SearchResultScreen()
                    //DetailScreen()
                    MainNavHost()
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FoodSearchTheme {
//        val navController = rememberNavController()
//        SearchScreen(navController = navController)
//    }
//}