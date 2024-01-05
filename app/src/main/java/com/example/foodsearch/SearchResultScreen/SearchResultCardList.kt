package com.example.foodsearch.SearchResultScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.R

@Composable
fun SearchResultCardList(restaurantList: List<RestaurantInfo>, onCardClick: (RestaurantInfo) -> Unit) {
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