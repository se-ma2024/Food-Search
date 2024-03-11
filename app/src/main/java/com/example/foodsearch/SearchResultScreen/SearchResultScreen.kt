package com.example.foodsearch.SearchResultScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SearchResultScreen(
    SearchWord: String?,
    viewModel: SearchResultViewModel,
    navController: NavController
) {
    val restaurantList = viewModel.filteredRestaurantList.value
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ResultTopBar(
            SearchWord = SearchWord,
            onNavigateUp = {
                navController.navigateUp()
            },
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            if (restaurantList.isNotEmpty()) {
                SearchResultCardList(restaurantList = restaurantList) { clickedRestaurant ->
                    viewModel.setClickedRestaurant(clickedRestaurant)
                    navController.navigate("DetailScreen")
                }
            } else {
                NoResultsMessage()
            }
        }
    }
}

@Composable
fun NoResultsMessage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "該当するレストランがありません",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
        )
    }
}

@Preview
@Composable
fun PreSearchResultScreen() {
    val navController = rememberNavController()
    // SearchResultScreen(SearchWord = "Sushi", viewModel = SearchResultViewModel(), navController = navController)
}
