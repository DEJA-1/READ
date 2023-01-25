package com.example.read.presentation.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.presentation.MainViewModel
import com.example.read.util.gradient

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: MainViewModel,
) {

    val bookList = viewModel.bookList.value.items

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)))
    ) {

        if (viewModel.isLoading.value) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = AppColors.mMain)
            }
        } else {
            Text(text = bookList.first().volumeInfo!!.title)
        }
    }

}