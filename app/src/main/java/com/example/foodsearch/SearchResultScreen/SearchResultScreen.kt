package com.example.foodsearch.SearchResultScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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

        // レストラン情報を表示する
        if (restaurantList.isNotEmpty()) {
            SearchResultCardList(restaurantList = restaurantList) { clickedRestaurant ->
                // カードがクリックされたときの処理
                // クリックされたレストラン情報をViewModelに保存
                viewModel.setClickedRestaurant(clickedRestaurant)
                // 詳細画面に遷移
                navController.navigate("DetailScreen")
            }
        } else {
            // レストラン情報がない場合の表示
            Text(
                "該当するレストランがありません",
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}


@Preview
@Composable
fun PreSearchResultScreen() {
    val navController = rememberNavController()
    //SearchResultScreen(navController = navController)
}