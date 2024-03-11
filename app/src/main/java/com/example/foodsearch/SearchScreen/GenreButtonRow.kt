package com.example.foodsearch.SearchScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun GenreButtonRow(
    genres: List<String>,
    onGenreSelected: (String) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(genres) { genre ->
            GenreButton(
                genre = genre,
                onGenreSelected = onGenreSelected
            )
        }
    }
}