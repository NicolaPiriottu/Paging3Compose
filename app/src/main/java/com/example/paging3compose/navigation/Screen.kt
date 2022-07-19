package com.example.paging3compose.navigation

/**
 * Created by Nicola Luigi Piriottu on 19/07/22.
 */
sealed class Screen(val route: String) {

    object Home : Screen("home_screen")
    object Search : Screen("search_screen")
}
