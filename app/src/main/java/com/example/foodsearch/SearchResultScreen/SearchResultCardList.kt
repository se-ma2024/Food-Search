package com.example.foodsearch.SearchResultScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodsearch.R

@Composable
fun SearchResultCardList(restaurantList: List<Restaurant>, onCardClick: (Restaurant) -> Unit) {
    LazyColumn {
        items(restaurantList) { restaurant ->
            SearchResultCard(restaurant = restaurant,
                onCardClick = { clickedRestaurant ->
                    // カードがクリックされたときの処理
                    onCardClick(clickedRestaurant)
                }
            )
        }
    }
}

@Preview
@Composable
fun PreSearchResultCardList() {
    // 仮のレストランデータのリスト
    val restaurantList = listOf(
        Restaurant(1, "Restaurant 1", R.drawable.ic_launcher_background, "Catch Copy 1"),
        Restaurant(2, "Restaurant 2", R.drawable.ic_launcher_background, "Catch Copy 2"),
        // 他のレストランデータも同様に追加
        Restaurant(3, "Restaurant 3", R.drawable.ic_launcher_background, "Catch Copy 3"),
        Restaurant(4, "Restaurant 4", R.drawable.ic_launcher_background, "Catch Copy 4"),
        Restaurant(5, "Restaurant 5", R.drawable.ic_launcher_background, "Catch Copy 5"),
        Restaurant(6, "Restaurant 6", R.drawable.ic_launcher_background, "Catch Copy 6"),
        Restaurant(7, "Restaurant 7", R.drawable.ic_launcher_background, "Catch Copy 7"),
        Restaurant(8, "Restaurant 8", R.drawable.ic_launcher_background, "Catch Copy 8"),
        Restaurant(9, "Restaurant 9", R.drawable.ic_launcher_background, "Catch Copy 9"),
        Restaurant(10, "Restaurant 10", R.drawable.ic_launcher_background, "Catch Copy 10"),
        Restaurant(11, "Restaurant 11", R.drawable.ic_launcher_background, "Catch Copy 11"),
        Restaurant(12, "Restaurant 12", R.drawable.ic_launcher_background, "Catch Copy 12"),
        Restaurant(13, "Restaurant 13", R.drawable.ic_launcher_background, "Catch Copy 13"),
        Restaurant(14, "Restaurant 14", R.drawable.ic_launcher_background, "Catch Copy 14"),
        Restaurant(15, "Restaurant 15", R.drawable.ic_launcher_background, "Catch Copy 15"),
        Restaurant(16, "Restaurant 16", R.drawable.ic_launcher_background, "Catch Copy 16"),
        Restaurant(17, "Restaurant 17", R.drawable.ic_launcher_background, "Catch Copy 17"),
        Restaurant(18, "Restaurant 18", R.drawable.ic_launcher_background, "Catch Copy 18"),
        Restaurant(19, "Restaurant 19", R.drawable.ic_launcher_background, "Catch Copy 19"),
        Restaurant(20, "Restaurant 20", R.drawable.ic_launcher_background, "Catch Copy 20")
    )
    // RestaurantList を呼び出す
    SearchResultCardList(restaurantList = restaurantList) { clickedRestaurant ->
        // カードがクリックされたときの処理
        // たとえば、詳細画面に遷移するなど
        //navController.navigate("RestaurantDetailScreen/${clickedRestaurant.id}")
    }
}

data class Restaurant(
    val id: Int,
    val name: String,
    val imageResId: Int,
    val catchCopy: String
)
