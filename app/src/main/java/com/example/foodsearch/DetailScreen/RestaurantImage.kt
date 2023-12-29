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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodsearch.R

@Composable
fun RestaurantImage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .shadow(
                elevation = 1.dp,
            )
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(4.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreDetailImange() {
    RestaurantImage()
}