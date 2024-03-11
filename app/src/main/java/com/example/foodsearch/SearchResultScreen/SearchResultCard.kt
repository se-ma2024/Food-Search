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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.foodsearch.DataSource.RestaurantInfo

@Composable
fun SearchResultCard(restaurant: RestaurantInfo, onCardClick: (RestaurantInfo) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onCardClick(restaurant) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = rememberAsyncImagePainter(restaurant.lMobileImage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = restaurant.name.orEmpty(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = restaurant.catchPhrase.orEmpty(),
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
