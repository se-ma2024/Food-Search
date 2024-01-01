package com.example.foodsearch.SearchResultScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.R

@Composable
fun SearchResultCard(restaurant: RestaurantInfo, onCardClick: (RestaurantInfo) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onCardClick(restaurant) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = restaurant.name ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            // イメージ画像
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // キャッチコピー
            Text(text = restaurant.catchPhrase ?: "")

            // 他の情報も必要に応じて表示できます
        }
    }
}

//@Preview
//@Composable
//fun PreSearchResultCard() {
//    val restaurantList = listOf(
//        Restaurant("Restaurant 1", R.drawable.ic_launcher_background, "Catch Copy 1"),
//        Restaurant("Restaurant 2", R.drawable.ic_launcher_background, "Catch Copy 2"),
//        // 他のレストランデータも同様に追加
//    )
//
//    // RestaurantList を呼び出す
//    SearchResultCardList(restaurantList = restaurantList,
//        onCardClick = { clickedRestaurant ->
//            // カードがクリックされたときの処理
//            //onCardClick(clickedRestaurant)
//        }
//    )
//}