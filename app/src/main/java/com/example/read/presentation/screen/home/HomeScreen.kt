package com.example.read.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.common_components.MyButton
import com.example.read.presentation.screen.home.components.CurrentlyReadingSection
import com.example.read.presentation.screen.home.components.Header
import com.example.read.presentation.screen.home.components.YourCollectionSection
import com.example.read.presentation.screen.profile.ProfileViewModel
import com.example.read.util.gradient
import com.example.read.util.handleAchievementState
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel,
    commonViewModel: CommonViewModel,
    profileViewModel: ProfileViewModel = hiltViewModel(),
) {
    val currentUser = FirebaseAuth.getInstance().currentUser
    val context = LocalContext.current

    val userBooks = viewModel.booksFromFB.value.filter {
        it.userId == currentUser?.uid.toString()
    }

    handleAchievementState(
        bookList = userBooks,
        achievementList = profileViewModel.achievementsFromFB.value.filter { it.userId == currentUser?.uid.toString() },
        commonViewModel
    )
    commonViewModel.getReadBooksSize(userBooks.filter { it.read && it.rated })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)))
    ) {
        Column(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp)
        ) {

            Header(nick = currentUser?.email?.split('@')?.first().toString()) {
                commonViewModel.calculateAvgRating(userBooks.filter { it.read && it.rated })
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

                if (userBooks.none { !it.read || !it.rated }) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.3f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Search for books!",
                            color = Color.DarkGray,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontSize = 32.sp,
                        )
                    }
                } else {
                    CurrentlyReadingSection(
                        context = context,
                        navController = navController,
                        userBooks = userBooks.filter { !it.read || !it.rated },
                        commonViewModel = commonViewModel,
                        viewModel = viewModel
                    )
                }

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

                if (userBooks.none { it.read && it.rated }) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Your collection is empty!",
                            color = Color.DarkGray,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontSize = 32.sp,
                        )
                    }
                } else {
                    YourCollectionSection(
                        navController = navController,
                        bookList = userBooks.filter { it.read && it.rated },
                        commonViewModel = commonViewModel
                    )
                }

            }
        }

    }
}






