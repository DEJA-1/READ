package com.example.read.presentation.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.domain.model.loadAchievements
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.screen.login.components.LoginSection
import com.example.read.util.gradient
import com.example.read.util.loadAchievementsToFirebase

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel,
    commonViewModel: CommonViewModel
) {

    val context = LocalContext.current

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

            LoginSection() { email, password ->
                if (!viewModel.isSignUp.value) {
                    viewModel.singInWithEmailAndPassword(email = email, password = password, context = context) {
                        loadAchievementsToFirebase(loadAchievements(), commonViewModel)
                        navController.navigate(Screen.Home.route)
                    }
                } else {
                    viewModel.createUserWithEmailAndPassword(email = email, password = password, context = context)

                }
            }
        }

    }

}