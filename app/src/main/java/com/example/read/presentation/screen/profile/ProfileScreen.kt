package com.example.read.presentation.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.screen.home.components.Header
import com.example.read.presentation.screen.profile.components.StatsSection
import com.example.read.util.gradient
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(navController: NavController) {

    val currentUser = FirebaseAuth.getInstance().currentUser

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)))
            .padding(8.dp)
    ) {
        Column() {
            Header(
                modifier = Modifier
                    .size(32.dp)
                    .padding(top = 8.dp),
                nick = currentUser?.email?.split('@')?.first().toString(),
                icon = Icons.Filled.Logout,
                isProfile = true
            ) {
                FirebaseAuth.getInstance().signOut().run {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            }

            Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
                StatsSection()
            }

        }
    }

}