package com.example.paging3compose.screens.home

import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.paging3compose.ui.theme.topAppBarBackgroundColor
import com.example.paging3compose.ui.theme.topAppBarContentColor

/**
 * Created by Nicola Luigi Piriottu on 19/07/22.
 */

@Composable
fun HomeTopBar(onSearchClicked: () -> Unit) {

    TopAppBar(
        title = {
            Text(
                text = "Home",
                color = colors.topAppBarContentColor
            )
        },
        backgroundColor = colors.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
private fun HomeTopBarPreview() {
    HomeTopBar {}
}