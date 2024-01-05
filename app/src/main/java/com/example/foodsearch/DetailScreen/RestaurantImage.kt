package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.foodsearch.DataSource.RestaurantInfo

@Composable
fun RestaurantImage(clickedRestaurant: RestaurantInfo?) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 1.dp,
            )
    ) {
        Image(
            painter = rememberAsyncImagePainter(clickedRestaurant?.lMobileImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(4.dp),
            contentScale = ContentScale.Crop
        )
    }
}

//@Preview(
//    showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun PreDetailImange() {
//    RestaurantImage()
//}