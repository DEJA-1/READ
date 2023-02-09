package com.example.read.presentation.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.read.R
import com.example.read.commons.AppColors
import com.example.read.domain.model.Achievement
import com.example.read.domain.model.loadAchievements
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.screen.home.HomeViewModel
import com.example.read.presentation.screen.home.components.Header
import com.example.read.presentation.screen.profile.components.AchievementsSection
import com.example.read.presentation.screen.profile.components.MyAlertDialog
import com.example.read.presentation.screen.profile.components.StatsSection
import com.example.read.presentation.screen.profile.components.YourFavoritesSection
import com.example.read.util.getFavCategory
import com.example.read.util.gradient
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(
    navController: NavController,
    commonViewModel: CommonViewModel,
    profileViewModel: ProfileViewModel
) {

    val currentUser = FirebaseAuth.getInstance().currentUser
    val context = LocalContext.current
    val userBooks = profileViewModel.booksFromFB.value.filter {
        it.userId == currentUser?.uid.toString()
    }

    val openDialog = remember {
        mutableStateOf(false)
    }

    val myAchievement = remember {
        mutableStateOf(Achievement())
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)))
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
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

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                modifier = Modifier.align(CenterHorizontally),
                text = "YOUR FAVORITE BOOKS",
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                color = AppColors.mTextWhite,
                textAlign = TextAlign.Center
            )

            if (userBooks.none { it.rating == 5 }) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "There are no books with rating 5.",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.DarkGray
                    )
                }
            } else {
                YourFavoritesSection(
                    modifier = Modifier.padding(start = 4.dp, top = 16.dp, bottom = 16.dp),
                    bookList = userBooks.filter { it.rating == 5 },
                    navController = navController,
                    context = context,
                    commonViewModel = commonViewModel
                )
            }

            Divider(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                color = Color.DarkGray,
                thickness = 2.dp
            )

            Box(
                contentAlignment = Alignment.TopCenter
            ) {
                StatsSection(
                    bookCount = commonViewModel.readBookSize.value,
                    ratingAvg = commonViewModel.avgRating.value,
                    category = getFavCategory(userBooks)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp, bottom = 8.dp),
                contentAlignment = Center
            ) {
                Card(
                    modifier = Modifier.fillMaxSize(),
                    elevation = 4.dp,
                    shape = RoundedCornerShape(12.dp),
                    backgroundColor = AppColors.mBackgroundSec,
                ) {
                    AchievementsSection(
                        context = context,
                        achievementList = profileViewModel.achievementsFromFB.value.filter { it.userId == currentUser?.uid }
                    ) { achievement ->
                        myAchievement.value = achievement
                        openDialog.value = !openDialog.value
                    }
                }
            }
        }

        if (openDialog.value)
            MyAlertDialog(openDialog = openDialog, achievement = myAchievement.value, context = context)
    }
}

