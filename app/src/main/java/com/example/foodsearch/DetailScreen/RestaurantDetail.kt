package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
            modifier = Modifier.padding(start = 4.dp, top = 4.dp),
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
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(4.dp)
            ) {
                Text(stringResource(R.string.BusinessHours))
                Text(
                    text = clickedRestaurant?.open ?: "情報なし",
                    modifier = Modifier.padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = stringResource(R.string.RegularHoliday))
                Text(
                    text = clickedRestaurant?.close ?: "情報なし",
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
            Text(
                text = clickedRestaurant?.catchPhrase ?: "情報なし",
                modifier = Modifier
                    .weight(2f)
                    .padding(8.dp)
            )
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Row() {
            Text(
                text = stringResource(R.string.AverageBudget), modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )
            Text(
                text = clickedRestaurant?.averageBudget ?: "情報なし",
                modifier = Modifier
                    .weight(2f)
                    .padding(8.dp)
            )
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Row() {
            Text(
                text = stringResource(R.string.Access), modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )
            Text(
                text = clickedRestaurant?.access ?: "情報なし",
                modifier = Modifier
                    .weight(2f)
                    .padding(8.dp)
            )
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