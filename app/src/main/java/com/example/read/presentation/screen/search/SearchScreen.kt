package com.example.read.presentation.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.screen.search.components.ForYouSection
import com.example.read.presentation.screen.search.components.SearchBar
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
        }
        else {
            Column(
                modifier = Modifier.padding(4.dp)
            ) {

                SearchBar { query ->
                    viewModel.changeLoadingState()
                    viewModel.getAllBooks(query)
                }

                LazyColumn(modifier = Modifier.fillMaxHeight(0.55f)) {
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

                Spacer(modifier = Modifier.height(20.dp))

                Divider(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                    color = Color.DarkGray,
                    thickness = 2.dp
                )

                ForYouSection(
                    context = context,
                    categoryList = viewModel.categoryList.shuffled().take(4)
                ) { query ->
                    viewModel.changeLoadingState()
                    viewModel.getAllBooks(query)
                }

            }
        }
    }

}