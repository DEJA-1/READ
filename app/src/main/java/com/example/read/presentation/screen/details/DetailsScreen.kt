package com.example.read.presentation.screen.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.screen.details.components.TopSection
import com.example.read.util.gradient

@Composable
fun DetailsScreen(
    navController: NavController,
    commonViewModel: CommonViewModel,
    viewModel: DetailsViewModel
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
                .background(AppColors.mMain)
                .align(Alignment.TopCenter)
        )

        TopSection(
            context = context,
            navController = navController,
            book = commonViewModel.currentBook.value,
            viewModel = viewModel
        )
    }
}