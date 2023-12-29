package com.example.foodsearch.SearchResultScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodsearch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultTopBar(SearchWord: String?, onNavigateUp: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        title = {
            if (SearchWord != null) {
                Text(text = SearchWord)
            }
            //検索ワードにできたらいいな
        },
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp),
    )
}

@Preview
@Composable
fun PreResultTopBar() {
    //ResultTopBar()
}