package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodsearch.R

@Composable
fun RestaurantName(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .shadow(1.dp)
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 40.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            text = "(" + stringResource(R.string.app_name) + ")",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun PreRestaurantName() {
    RestaurantName()
}