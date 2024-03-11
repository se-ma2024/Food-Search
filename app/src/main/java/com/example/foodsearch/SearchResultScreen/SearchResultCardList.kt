package com.example.foodsearch.SearchResultScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.foodsearch.DataSource.RestaurantInfo

@Composable
fun SearchResultCardList(
    restaurantList: List<RestaurantInfo>,
    onCardClick: (RestaurantInfo) -> Unit
) {
    LazyColumn {
        items(restaurantList) { restaurant ->
            SearchResultCard(restaurant = restaurant,
                onCardClick = { clickedRestaurant ->
                    onCardClick(clickedRestaurant)
                }
            )
        }
    }
}