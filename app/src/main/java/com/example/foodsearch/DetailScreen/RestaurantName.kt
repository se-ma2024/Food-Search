package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodsearch.DataSource.RestaurantInfo

@Composable
fun RestaurantName(clickedRestaurant: RestaurantInfo?) {
    Column(
        modifier = Modifier
            .shadow(1.dp)
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
    ) {
        Text(
            text = clickedRestaurant?.name ?: "店舗名",
            fontSize = 40.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            text = "(" + clickedRestaurant?.nameKana ?: "店舗名" + ")",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

//@Preview(
//    showBackground = true,
//)
//@Composable
//fun PreRestaurantName() {
//    RestaurantName()
//}