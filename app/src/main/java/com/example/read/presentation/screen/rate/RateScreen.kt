package com.example.read.presentation.screen.rate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.common_components.MyButton
import com.example.read.util.gradient

@Composable
fun RateScreen(
    navController: NavController,
    commonViewModel: CommonViewModel,
    rateViewModel: RateViewModel
) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec))),
        contentAlignment = Alignment.Center
    ) {

        Column() {
            Text(
                text = commonViewModel.currentBook.value.title.toString(),
                color = AppColors.mTextWhite,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            MyButton(
                text = "SAVE"
            ) {
                commonViewModel.updateBookRate(commonViewModel.currentBook.value, isRated = true, context)
                navController.navigate(Screen.Home.route)
            }
        }

    }

}