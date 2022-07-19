package com.example.paging3compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.paging3compose.screens.home.HomeScreen

/**
 * Created by Nicola Luigi Piriottu on 19/07/22.
 */

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navHostController = navController)
        }

        composable(route = Screen.Search.route) {
           // SearchScreen(navController = navController)
        }
    }
}