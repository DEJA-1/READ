package com.example.read.presentation.screen.rate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.common_components.MyButton
import com.example.read.presentation.screen.rate.components.NoteSection
import com.example.read.presentation.screen.rate.components.RatingSection
import com.example.read.util.gradient

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RateScreen(
    navController: NavController,
    commonViewModel: CommonViewModel,
    rateViewModel: RateViewModel
) {

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val note = remember {
        mutableStateOf("")
    }

    val rate = remember {
        mutableStateOf(1)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient(colors = listOf(AppColors.mBackground, AppColors.mBackgroundSec)))
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = commonViewModel.currentBook.value.title.toString(),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = AppColors.mTextWhite,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = commonViewModel.currentBook.value.authors.toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,
                    color = AppColors.mTextWhite,
                    textAlign = TextAlign.Center
                )
            }

            NoteSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f),
                valueState = note
            ) {
                keyboardController?.hide()
            }

            RatingSection(rate = rate)

            MyButton(
                text = "SAVE"
            ) {
                commonViewModel.updateBookRate(commonViewModel.currentBook.value, isRated = true, rating = rate.value, context)
                commonViewModel.updateBookNote(commonViewModel.currentBook.value, note = note.value, context)
                navController.navigate(Screen.Home.route)
            }
        }

    }

}