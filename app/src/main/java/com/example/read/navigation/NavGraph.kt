package com.example.read.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.screen.search.SearchViewModel
import com.example.read.presentation.screen.details.DetailsScreen
import com.example.read.presentation.screen.details.DetailsViewModel
import com.example.read.presentation.screen.home.HomeScreen
import com.example.read.presentation.screen.home.HomeViewModel
import com.example.read.presentation.screen.login.LoginScreen
import com.example.read.presentation.screen.login.LoginViewModel
import com.example.read.presentation.screen.profile.ProfileScreen
import com.example.read.presentation.screen.profile.ProfileViewModel
import com.example.read.presentation.screen.rate.RateScreen
import com.example.read.presentation.screen.search.SearchScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val commonViewModel = hiltViewModel<CommonViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screen.Profile.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController = navController, viewModel = homeViewModel, commonViewModel = commonViewModel)
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
            SearchScreen(navController = navController, viewModel = searchViewModel, commonViewModel = commonViewModel)
        }

        composable(
            route = Screen.Details.route
        ) {
            val detailsViewModel = hiltViewModel<DetailsViewModel>()
            DetailsScreen(navController = navController, commonViewModel = commonViewModel, viewModel = detailsViewModel)
        }

        composable(
            route = Screen.Rate.route
        ) {
            RateScreen(navController = navController, commonViewModel = commonViewModel)
        }

        composable(
            route = Screen.Profile.route
        ) {
            val profileViewModel = hiltViewModel<ProfileViewModel>()
            ProfileScreen(navController = navController, commonViewModel = commonViewModel, profileViewModel = profileViewModel)
        }
    }
}