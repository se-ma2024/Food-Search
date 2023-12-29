package com.example.foodsearch.SearchScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SearchScreen(navController: NavController) {
    var searchWord by remember { mutableStateOf("") }
    var searchRange by remember { mutableStateOf("1000m")}
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar()
        SearchBar(
            SearchWord = searchWord,
            onSearch = {
                // 画面遷移を行う
                navController.navigate("SearchResultScreen/$searchWord/$searchRange")
            },
            onSearchWordChange = { newSearchWord ->
                // SearchWord の変更を検知し、更新
                searchWord = newSearchWord
            }
        )
        Spacer(modifier = Modifier.height(4.dp))
        SearchRange(
            options = listOf("300m", "500m", "1000m", "2000m", "3000m"),
            onOptionSelected = { range ->
                // Handle the event passed from outside
                searchRange = range
                println("Selected Option: $range")
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
                navController.navigate("SearchResultScreen/$genre/$searchRange")
            }
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreSearchScreen() {
    val navController = rememberNavController()
    SearchScreen(navController = navController)
}