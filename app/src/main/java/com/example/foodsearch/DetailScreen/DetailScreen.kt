package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodsearch.SearchResultScreen.ResultTopBar

@Composable
fun DetailScreen(restaurantId: Int?, modifier: Modifier = Modifier,navController: NavController) {
    Column() {
        ResultTopBar(
            SearchWord = "店舗名にしたい",
            onNavigateUp = {
                // バックナビゲーションがクリックされたときの処理
                navController.navigateUp()
            }
        )
        DetailScreenScrool()
    }
}


@Preview(showBackground = true)
@Composable
fun PreDetailScreen() {
    val navController = rememberNavController()
    DetailScreen(1, navController = navController)
}