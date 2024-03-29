package com.example.foodsearch.SearchScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Close
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.foodsearch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    SearchWord: String,
    onSearch: (String) -> Unit,
    onSearchWordChange: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = SearchWord,
            onValueChange = {
                onSearchWordChange(it)
            },
            label = { Text(stringResource(R.string.SearchWord)) },
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search,
            ),
            leadingIcon = {
                Icon(
                    Icons.Sharp.Search,
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Sharp.Close,
                    contentDescription = "×",
                    modifier = Modifier.clickable {
                        onSearchWordChange("")
                    }
                )
            },
            keyboardActions = KeyboardActions(
                onSearch = {
                    // 検索アクションが発生したら外部に通知
                    onSearch(SearchWord)
                }
            ),
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}