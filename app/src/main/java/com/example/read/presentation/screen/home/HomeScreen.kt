package com.example.read.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.domain.model.MyItem
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.common_components.MyButton
import com.example.read.presentation.screen.home.components.CurrentlyReadingSection
import com.example.read.presentation.screen.home.components.Header
import com.example.read.presentation.screen.home.components.YourCollectionSection
import com.example.read.util.gradient

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel,
    commonViewModel: CommonViewModel
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

            Spacer(modifier = Modifier.height(20.dp))

            CurrentlyReadingSection(
                context = context,
                navController = navController,
                userBooks = listOf(commonViewModel.currentBook.value),
                commonViewModel = commonViewModel
            )

            MyButton(
                text = "SEARCH", modifier = Modifier
                    .padding(top = 20.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                navController.navigate(Screen.Search.route)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Divider(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                color = Color.DarkGray,
                thickness = 2.dp
            )

            YourCollectionSection(navController = navController)
        }

    }

}

