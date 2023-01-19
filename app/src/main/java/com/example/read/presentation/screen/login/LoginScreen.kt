package com.example.read.presentation.screen.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.screen.login.components.LoginSection
import com.example.read.util.gradient

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                gradient(
                    colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            LoginSection(navController = navController) { email, password ->
                Log.d("TEstLogin", "$email, $password")
                viewModel.singInWithEmailAndPassword(email, password) {
                    navController.navigate(Screen.Home.route)
                }
            }
        }

    }

}