package com.example.foodsearch.SearchScreen

import LocationSensor
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchScreenViewModel,
    locationSensor: LocationSensor
) {
    var searchWord by remember { mutableStateOf("") }
    var searchRange by remember { mutableStateOf("1000m") }
    var range by remember { mutableStateOf(3) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar()
        SearchBar(
            SearchWord = searchWord,
            onSearch = {
                viewModel.viewModelScope.launch {
                    try {
                        val location = locationSensor.getLocation()
                        viewModel.searchRestaurants(
                            apiKey = "79e2666acd1d3353",
                            keyword = searchWord,
//                            latitude = 34.705647748772236,
//                            longitude = 135.49483743011916,
                            latitude = location?.latitude ?: 0.0,
                            longitude = location?.longitude ?: 0.0,
                            start = 1,
                            count = 100,
                            format = "json",
                            range = range
                        )
                        navController.navigate("SearchResultScreen/$searchWord")
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            },
            onSearchWordChange = { newSearchWord ->
                searchWord = newSearchWord
            }
        )
        Spacer(modifier = Modifier.height(4.dp))
        SearchRange(
            options = listOf("300m", "500m", "1000m", "2000m", "3000m"),
            onOptionSelected = { newRange ->
                searchRange = newRange
                range = when (newRange) {
                    "300m" -> 1
                    "500m" -> 2
                    "1000m" -> 3
                    "2000m" -> 4
                    "3000m" -> 5
                    else -> 3
                }
                println("Selected Option: $newRange, Corresponding Range: $range")
            }
        )
        GenreButtonRow(
            genres = listOf(
                "和食",
                "ラーメン",
                "イタリアン",
                "フレンチ",
                "アメリカン",
                "中華料理",
                "カフェ",
                "居酒屋",
                "デザート"
            ),
            onGenreSelected = { genre ->
                println("Selected Genre: $genre")
                viewModel.viewModelScope.launch {
                    try {
                        val location = locationSensor.getLocation()
                        viewModel.searchRestaurants(
                            apiKey = "79e2666acd1d3353",
                            keyword = genre,
                            latitude = location?.latitude ?: 0.0, // ダミーの緯度経度
                            longitude = location?.longitude ?: 0.0,
//                            latitude = 34.705647748772236,
//                            longitude = 135.49483743011916,
                            start = 1,
                            count = 100,
                            format = "json",
                            range = range
                        )
                        navController.navigate("SearchResultScreen/$genre")
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        )
    }
}