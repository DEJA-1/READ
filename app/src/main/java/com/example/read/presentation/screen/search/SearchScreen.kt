package com.example.read.presentation.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.screen.search.components.SearchBookRow
import com.example.read.util.gradient

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel,
    commonViewModel: CommonViewModel
) {

    val bookList = viewModel.bookList.value.items
    val context = LocalContext.current

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
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                LazyColumn {
                    items(bookList) { book ->
                        SearchBookRow(
                            context = context,
                            book = book,
                        ) {
                            commonViewModel.updateCurrentBook(book)
                            navController.navigate(Screen.Details.route)
                        }
                    }
                }

            }
        }
    }

}