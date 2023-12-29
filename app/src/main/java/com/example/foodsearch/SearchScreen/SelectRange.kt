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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodsearch.R

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SearchRange(
//    options: List<String>,
//    onOptionSelected: (String) -> Unit
//) {
//    var expanded by remember { mutableStateOf(false) }
//    var selectedOptionText by remember { mutableStateOf(options[2]) }
//
//    // We want to react on tap/press on TextField to show menu
//    ExposedDropdownMenuBox(
//        expanded = expanded,
//        onExpandedChange = { expanded = it },
//    ) {
//        TextField(
//            // The `menuAnchor` modifier must be passed to the text field for correctness.
//            modifier = Modifier.menuAnchor(),
//            readOnly = true,
//            value = selectedOptionText,
//            onValueChange = {},
//            label = { Text(stringResource(R.string.SearchRange)) },
//            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
//            colors = ExposedDropdownMenuDefaults.textFieldColors(),
//        )
//
//        // ドロップダウンメニュー
//        ExposedDropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false },
//        ) {
//            options.forEach { selectionOption ->
//                // ドロップダウンアイテム
//                DropdownMenuItem(
//                    text = { Text(selectionOption) },
//                    onClick = {
//                        selectedOptionText = selectionOption
//                        expanded = false
//                        // 外部から渡されたイベント処理を実行
//                        onOptionSelected(selectionOption)
//                    },
//                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
//                )
//            }
//        }
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun PreSelectRange() {
//    SearchRange(
//        options = listOf("300m", "500m", "1000m", "2000m", "3000m"),
//        onOptionSelected = { selectedOption ->
//            // 外部から渡されたイベント時の処理
//            // 例えば、選択されたオプションに基づいた処理を実行するなど
//            println("Selected Option: $selectedOption")
//        }
//    )
//}


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
            .padding(top = 56.dp) // Adjust the top padding to position the dropdown
    ) {
        options.forEach { range ->
            // DropdownMenuItem
            DropdownMenuItem(
                text = { Text(text = range) },
                onClick = {
                    rangeText = range
                    expanded = false
                    keyboardController?.hide()
                    // Execute the event handling passed from outside
                    onOptionSelected(range)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SearchRangePreview() {
    SearchRange(
        options = listOf("300m", "500m", "1000m", "2000m", "3000m"),
        onOptionSelected = { range ->
            // Handle the event passed from outside
            println("Selected Option: $range")
        }
    )
}