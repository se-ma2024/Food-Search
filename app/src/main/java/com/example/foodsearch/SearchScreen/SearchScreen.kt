package com.example.foodsearch.SearchScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar()
        SearchBar()
        Spacer(modifier = Modifier.height(4.dp))
        SearchRange(
            options = listOf("300m", "500m", "1000m", "2000m", "3000m"),
            onOptionSelected = { range ->
                // Handle the event passed from outside
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
    SearchScreen()
}