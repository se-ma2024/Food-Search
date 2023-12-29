package com.example.foodsearch.SearchResultScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodsearch.R

@Composable
fun SearchResultCardList(restaurantList: List<Restaurant>) {
    LazyColumn {
        items(restaurantList) { restaurant ->
            SearchResultCard(restaurant = restaurant)
        }
    }
}

@Preview
@Composable
fun PreSearchResultCardList() {
    // 仮のレストランデータのリスト
    val restaurantList = listOf(
        Restaurant("Restaurant 1", R.drawable.ic_launcher_background, "Catch Copy 1"),
        Restaurant("Restaurant 2", R.drawable.ic_launcher_background, "Catch Copy 2"),
        // 他のレストランデータも同様に追加
        Restaurant("Restaurant 3", R.drawable.ic_launcher_background, "Catch Copy 3"),
        Restaurant("Restaurant 4", R.drawable.ic_launcher_background, "Catch Copy 4"),
        Restaurant("Restaurant 5", R.drawable.ic_launcher_background, "Catch Copy 5"),
        Restaurant("Restaurant 6", R.drawable.ic_launcher_background, "Catch Copy 6"),
        Restaurant("Restaurant 7", R.drawable.ic_launcher_background, "Catch Copy 7"),
        Restaurant("Restaurant 8", R.drawable.ic_launcher_background, "Catch Copy 8"),
        Restaurant("Restaurant 9", R.drawable.ic_launcher_background, "Catch Copy 9"),
        Restaurant("Restaurant 10", R.drawable.ic_launcher_background, "Catch Copy 10"),
        Restaurant("Restaurant 11", R.drawable.ic_launcher_background, "Catch Copy 11"),
        Restaurant("Restaurant 12", R.drawable.ic_launcher_background, "Catch Copy 12"),
        Restaurant("Restaurant 13", R.drawable.ic_launcher_background, "Catch Copy 13"),
        Restaurant("Restaurant 14", R.drawable.ic_launcher_background, "Catch Copy 14"),
        Restaurant("Restaurant 15", R.drawable.ic_launcher_background, "Catch Copy 15"),
        Restaurant("Restaurant 16", R.drawable.ic_launcher_background, "Catch Copy 16"),
        Restaurant("Restaurant 17", R.drawable.ic_launcher_background, "Catch Copy 17"),
        Restaurant("Restaurant 18", R.drawable.ic_launcher_background, "Catch Copy 18"),
        Restaurant("Restaurant 19", R.drawable.ic_launcher_background, "Catch Copy 19"),
        Restaurant("Restaurant 20", R.drawable.ic_launcher_background, "Catch Copy 20")
    )

    // RestaurantList を呼び出す
    SearchResultCardList(restaurantList = restaurantList)
}

data class Restaurant(
    val name: String,
    val imageResId: Int,
    val catchCopy: String
)
