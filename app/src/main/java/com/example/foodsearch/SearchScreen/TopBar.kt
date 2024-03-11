package com.example.foodsearch.SearchScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.foodsearch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        },
        title = {
            Text(text = stringResource(R.string.app_name))
        },
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp),
    )
}