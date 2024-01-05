package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.foodsearch.DataSource.RestaurantInfo

@Composable
fun RestaurantName(clickedRestaurant: RestaurantInfo?) {
    Column(
        modifier = Modifier
            .shadow(1.dp)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = clickedRestaurant?.name ?: "店舗名",
            style = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 1.em,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    ),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.None
                    )
                )
            ),
            fontSize = 40.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            text = "(" + clickedRestaurant?.nameKana + ")",
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