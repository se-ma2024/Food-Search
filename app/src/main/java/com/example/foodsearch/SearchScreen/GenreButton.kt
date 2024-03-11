package com.example.foodsearch.SearchScreen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenreButton(
    genre: String,
    onGenreSelected: (String) -> Unit
) {
    OutlinedButton(
        onClick = { onGenreSelected(genre) },
        modifier = Modifier
            .padding(end = 8.dp)
            .height(40.dp)
    ) {
        Text(text = genre)
    }
}