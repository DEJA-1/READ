package com.example.read.presentation.screen.home.components

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.read.commons.AppColors
import com.example.read.domain.model.MyItem
import com.example.read.navigation.Screen
import com.example.read.presentation.common_components.MyButton
import com.example.read.presentation.screen.home.HomeViewModel
import com.example.read.util.isValid

@Composable
fun CurrentlyReadingSection(
    userBooks: List<MyItem>,
    context: Context = LocalContext.current,
    viewModel: HomeViewModel,
    navController: NavController,
) {

    Column(
        modifier = Modifier.padding()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Currently reading",
            color = AppColors.mTextWhite,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow() {
            items(userBooks) { book ->
                BookRow(
                    userBooks = userBooks,
                    onItemClicked = { viewModel.changeCardExpandedState() }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(AppColors.mBackgroundSec),
                        contentAlignment = BottomCenter
                    ) {

                        Row {
                            AnimatedVisibility(visible = viewModel.isCardExpanded.value) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Center
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        MyButton(
                                            modifier = Modifier
                                                .fillMaxWidth(0.7f)
                                                .fillMaxHeight(0.2f)
                                                .clip(RoundedCornerShape(12.dp)),
                                            text = "READ",
                                            fontSize = 12,
                                            contentPadding = 8
                                        ) {
                                            viewModel.changeReadState()
                                            viewModel.changeCardExpandedState()
                                        }
                                        Spacer(modifier = Modifier.height(4.dp))

                                        MyButton(
                                            modifier = Modifier
                                                .fillMaxWidth(0.7f)
                                                .fillMaxHeight(0.24f)
                                                .clip(RoundedCornerShape(12.dp)),
                                            text = "RATE",
                                            fontSize = 12,
                                            contentPadding = 8
                                        ) {
                                            navController.navigate(Screen.Rate.route)
                                        }

                                    }

                                }

                            }
                            AsyncImage(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(12.dp)),
                                model = ImageRequest.Builder(context)
                                    .data(
                                        if (isValid(book.volumeInfo?.imageLinks?.thumbnail))
                                            book.volumeInfo?.imageLinks?.thumbnail
                                        else
                                            com.example.read.R.drawable.imagenotfound
                                    )
                                    .crossfade(true)
                                    .build(),
                                contentScale = ContentScale.FillBounds,
                                contentDescription = "Book image"
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.1f)
                                .background(if (viewModel.isBookRead.value) AppColors.mGreen else AppColors.mRed)
                        )

                    }
                }
            }
        }
    }
}