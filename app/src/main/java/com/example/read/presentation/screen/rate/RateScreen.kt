package com.example.read.presentation.screen.rate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.common_components.MyButton
import com.example.read.presentation.screen.rate.components.NoteSection
import com.example.read.presentation.screen.rate.components.RateTopSection
import com.example.read.presentation.screen.rate.components.RatingSection
import com.example.read.util.gradient

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RateScreen(
    navController: NavController,
    commonViewModel: CommonViewModel,
) {

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    val note = remember {
        mutableStateOf(commonViewModel.currentBook.value.note)
    }

    val rate = remember {
        mutableStateOf(commonViewModel.currentBook.value.rating)
    }

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

        Column() {
            RateTopSection(
                navController = navController,
                context = context,
                book = commonViewModel.currentBook.value
            ) {
                commonViewModel.updateBookRate(
                    commonViewModel.currentBook.value,
                    isRated = true,
                    rating = rate.value,
                    context
                )
                commonViewModel.updateBookNote(
                    commonViewModel.currentBook.value,
                    note = note.value,
                    context
                )
                navController.navigate(Screen.Home.route)
            }

            Card(
                modifier = Modifier.padding(8.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(12.dp),
                backgroundColor = AppColors.mBackgroundSec
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    RatingSection(rate = rate)

                    NoteSection(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(1f),
                        valueState = note
                    ) {
                        keyboardController?.hide()
                    }

                }

            }
        }

//            MyButton(
//                text = "SAVE"
//            ) {
//                commonViewModel.updateBookRate(commonViewModel.currentBook.value, isRated = true, rating = rate.value, context)
//                commonViewModel.updateBookNote(commonViewModel.currentBook.value, note = note.value, context)
//                navController.navigate(Screen.Home.route)
//            }
    }

}

