package com.example.foodsearch.SearchScreen

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

// SearchScreen.kt

@Composable
fun SearchScreen(navController: NavController, viewModel: SearchScreenViewModel) {
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
                        // SearchScreenViewModel の searchRestaurants を呼び出す
                        viewModel.searchRestaurants(
                            apiKey = "79e2666acd1d3353",
                            keyword = searchWord,
                            latitude = 34.705647748772236,
                            longitude = 135.49483743011916,
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
                // SearchWord の変更を検知し、更新
                searchWord = newSearchWord
            }
        )
        Spacer(modifier = Modifier.height(4.dp))
        SearchRange(
            options = listOf("300m", "500m", "1000m", "2000m", "3000m"),
            onOptionSelected = { newRange ->
                // Handle the event passed from outside
                searchRange = newRange
                // 更新された SearchRange に対応する range の値を設定
                range = when (newRange) {
                    "300m" -> 1
                    "500m" -> 2
                    "1000m" -> 3
                    "2000m" -> 4
                    "3000m" -> 5
                    else -> 3 // デフォルトは 1000m
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
                // Handle the genre selection
                println("Selected Genre: $genre")
                // genreに基づいてAPIリクエストを実行
                viewModel.viewModelScope.launch {
                    try {
                        viewModel.searchRestaurants(
                            apiKey = "79e2666acd1d3353",
                            keyword = genre,
                            latitude = 34.705647748772236,
                            longitude = 135.49483743011916,
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


//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
//@Composable
//fun PreSearchScreen() {
//    val navController = rememberNavController()
//    SearchScreen(navController = navController)
//}