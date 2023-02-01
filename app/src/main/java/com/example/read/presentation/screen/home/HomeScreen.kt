package com.example.read.presentation.screen.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.MyItem
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.common_components.MyButton
import com.example.read.presentation.screen.home.components.CurrentlyReadingSection
import com.example.read.presentation.screen.home.components.Header
import com.example.read.presentation.screen.home.components.YourCollectionSection
import com.example.read.util.gradient
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel,
    commonViewModel: CommonViewModel,
) {
    val currentUser = FirebaseAuth.getInstance().currentUser
    val context = LocalContext.current

//    val userBooks = viewModel.booksFromFB.value.filter {
//        it.userId == currentUser?.uid.toString()
//    }

    val userBooks = viewModel.booksFromFB.value.filter {
        it.userId == currentUser?.uid.toString()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)))
    ) {
        Column(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp)
        ) {

            Header(nick = currentUser?.email?.split('@')?.first().toString()) {
                navController.navigate(Screen.Profile.route)
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (viewModel.isLoading.value) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = AppColors.mMain)
                }
            } else {
                if (userBooks.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "The list is empty.", color = Color.DarkGray)
                    }
                } else {
                    CurrentlyReadingSection(
                        context = context,
                        navController = navController,
                        userBooks = userBooks.filter { it.read == false },
//                        userBooks = mUserBooks,
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

                    if (userBooks.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "The list is empty.", color = Color.DarkGray)
                        }
                    } else {
                        YourCollectionSection(
                            navController = navController,
                            bookList = userBooks.filter { it.read == true })
                    }
                }
            }

        }
    }

}




