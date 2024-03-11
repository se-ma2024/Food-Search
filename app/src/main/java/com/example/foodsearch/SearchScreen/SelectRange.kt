package com.example.foodsearch.SearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.foodsearch.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchRange(
    options: List<String>,
    onOptionSelected: (String) -> Unit

) {
    var expanded by remember { mutableStateOf(false) }
    var rangeText by remember { mutableStateOf(options[2]) }
    val keyboardController by rememberUpdatedState(LocalSoftwareKeyboardController.current)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                expanded = !expanded
                keyboardController?.hide()
            }
    ) {
        Text(text = stringResource(R.string.SearchRange_xxx, rangeText))
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Dropdown",
            modifier = Modifier.padding(start = 4.dp)
        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {
            expanded = false
            keyboardController?.hide()
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .clip(MaterialTheme.shapes.medium)
            .padding(top = 56.dp)
    ) {
        options.forEach { range ->
            DropdownMenuItem(
                text = { Text(text = range) },
                onClick = {
                    rangeText = range
                    expanded = false
                    keyboardController?.hide()
                    onOptionSelected(range)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}