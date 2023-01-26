package com.example.read.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.read.presentation.screen.search.SearchViewModel
import com.example.read.presentation.screen.details.DetailsScreen
import com.example.read.presentation.screen.home.HomeScreen
import com.example.read.presentation.screen.home.HomeViewModel
import com.example.read.presentation.screen.login.LoginScreen
import com.example.read.presentation.screen.login.LoginViewModel
import com.example.read.presentation.screen.profile.ProfileScreen
import com.example.read.presentation.screen.rate.RateScreen
import com.example.read.presentation.screen.search.SearchScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Search.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            val homeViewModel: HomeViewModel = viewModel()
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Login.route
        ) {
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(navController = navController, viewModel = loginViewModel)
        }

        composable(
            route = Screen.Search.route
        ) {
            val searchViewModel = hiltViewModel<SearchViewModel>()
            SearchScreen(navController = navController, viewModel = searchViewModel)
        }

        composable(
            route = Screen.Details.route
        ) {
            DetailsScreen(navController = navController)
        }

        composable(
            route = Screen.Rate.route
        ) {
            RateScreen(navController = navController)
        }

        composable(
            route = Screen.Profile.route
        ) {
            ProfileScreen(navController = navController)
        }
    }
}