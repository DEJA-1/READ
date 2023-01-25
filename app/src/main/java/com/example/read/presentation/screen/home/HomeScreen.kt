package com.example.read.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.screen.home.components.CurrentlyReadingSection
import com.example.read.presentation.screen.home.components.Header
import com.example.read.presentation.screen.home.components.YourCollectionSection
import com.example.read.util.gradient

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)))
    ) {
        Column(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp)
        ) {

            Header(nick = viewModel.currentUser?.email?.split('@')?.first().toString()) {
                navController.navigate(Screen.Profile.route)
            }

            Spacer(modifier = Modifier.height(40.dp))

            CurrentlyReadingSection(context = context)
            
            Spacer(modifier = Modifier.height(60.dp))

            Divider(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                color = AppColors.mMain,
                thickness = 2.dp
            )

            YourCollectionSection()
        }

    }

}

