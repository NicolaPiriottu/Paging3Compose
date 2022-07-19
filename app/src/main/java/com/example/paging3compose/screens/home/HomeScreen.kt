package com.example.paging3compose.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.paging3compose.navigation.Screen
import com.example.paging3compose.screens.common.ListContent

/**
 * Created by Nicola Luigi Piriottu on 19/07/22.
 */

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val getAllImages = homeViewModel.getAllImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(
                onSearchClicked = {
                    navHostController.navigate(Screen.Search.route)
                })
        },
        content = {
            ListContent(items = getAllImages)
        }
    )
}