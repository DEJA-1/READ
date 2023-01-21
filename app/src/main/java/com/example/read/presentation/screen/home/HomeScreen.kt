package com.example.read.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.screen.home.components.CurrentlyReadingSection
import com.example.read.presentation.screen.home.components.Header
import com.example.read.util.gradient

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)))
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {

            Header(nick = viewModel.currentUser?.email?.split('@')?.first().toString()) {
                navController.navigate(Screen.Profile.route)
            }

            Spacer(modifier = Modifier.height(20.dp))

            CurrentlyReadingSection()
        }

    }

}

