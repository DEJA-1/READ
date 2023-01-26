package com.example.read.presentation.screen.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.screen.search.SearchViewModel
import com.example.read.util.gradient

@Composable
fun DetailsScreen(
    navController: NavController,
    commonViewModel: CommonViewModel
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)))
    ) {
        Text(
            text = commonViewModel.currentBook.value.volumeInfo?.title.toString())
    }
}