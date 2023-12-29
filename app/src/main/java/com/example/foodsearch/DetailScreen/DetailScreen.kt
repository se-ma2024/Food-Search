package com.example.foodsearch.DetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodsearch.SearchResultScreen.ResultTopBar

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Column() {
        ResultTopBar()
        DetailScreenScrool()
    }
}


@Preview(showBackground = true)
@Composable
fun PreDetailScreen() {
    DetailScreen()
}