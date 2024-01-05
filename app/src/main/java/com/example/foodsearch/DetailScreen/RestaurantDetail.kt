package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.foodsearch.DataSource.RestaurantInfo
import com.example.foodsearch.R

@Composable
fun RestaurantDetail(clickedRestaurant: RestaurantInfo?) {
    Column(
        modifier = Modifier
            .shadow(
                elevation = 1.dp,
            )
            .padding(4.dp)
    ) {
        Text(
            text = stringResource(R.string.RestaurantDetail),
            modifier = Modifier.padding(start = 4.dp),
            style = MaterialTheme.typography.headlineSmall
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.BusinessHours), modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(stringResource(R.string.BusinessHours))
                Text(
                    text = clickedRestaurant?.open ?: " ~ ",
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(text = stringResource(R.string.RegularHoliday))
                Text(
                    text = clickedRestaurant?.close ?: " ~ ",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Row() {
            Text(
                text = stringResource(R.string.ShopCatchphrase), modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )
            Text(text = clickedRestaurant?.catchPhrase ?: " ~ ", modifier = Modifier.weight(1f))
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Row() {
            Text(
                text = stringResource(R.string.AverageBudget), modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )
            Text(text = clickedRestaurant?.averageBudget ?: " ~ ", modifier = Modifier.weight(1f))
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Row() {
            Text(
                text = stringResource(R.string.Access), modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )
            Text(text = clickedRestaurant?.access ?: " ~ ", modifier = Modifier.weight(1f))
        }

    }
}

@Composable
fun HorizontalDivider(modifier: Modifier = Modifier) {
    Column() {
        Divider(
            modifier = modifier
                .fillMaxWidth()
                .height(1.dp)
        )
    }
}

//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
//@Composable
//fun PreRestaurantDetail() {
//    RestaurantDetail()
//}