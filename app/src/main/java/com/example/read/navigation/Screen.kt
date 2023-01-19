package com.example.read.navigation

sealed class Screen(val route: String) {
    object Login: Screen(route = "login_screen")
    object Home: Screen(route = "home_screen")
    object Search: Screen(route = "search_screen")
    object Details: Screen(route = "details_screen")
    object Rate: Screen(route = "rate_screen")
    object Profile: Screen(route = "profile_screen")
}
