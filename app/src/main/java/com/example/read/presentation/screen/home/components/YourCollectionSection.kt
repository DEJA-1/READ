package com.example.read.presentation.screen.home.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.read.R
import com.example.read.commons.AppColors
import com.example.read.domain.model.BookFB
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel

@Composable
fun YourCollectionSection(
    context: Context = LocalContext.current,
    bookList: List<BookFB>,
    navController: NavController,
    commonViewModel: CommonViewModel
) {

    Column() {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Your collection",
            color = AppColors.mTextWhite,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow() {
            items(bookList) { book ->
                BookRow(
                    modifier = Modifier.padding(4.dp),
                    shapeDp = 12,
                    heightSize = 150,
                    book = book,
                    widthSize = 110,
                    isYourCollection = true,
                    onItemClicked = {
                        commonViewModel.updateCurrentBook(book)
                        navController.navigate(Screen.Rate.route) }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {

                        AsyncImage(
                            modifier = Modifier
                                .fillMaxSize(),
                            model = ImageRequest.Builder(context)
                                .data(book.image)
                                .crossfade(true)
                                .build(),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = "Book image"
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .fillMaxHeight(0.2f)
                                .align(Alignment.BottomStart)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.Black),
                            contentAlignment = Alignment.Center
                        ) {
                            Row() {
                                Text(
                                    text = if (book.rated == true) book.rating.toString() else "Not rated",
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 16.sp,
                                    color = AppColors.mTextWhite,
                                    textAlign = TextAlign.Center

                                )

                                if (book.rated == true) {
                                    Icon(
                                        imageVector = Icons.Filled.Star,
                                        contentDescription = "star icon",
                                        tint = AppColors.mMain,
                                        modifier = Modifier.size(22.dp)
                                    )
                                }

                            }
                        }
                    }

                }
            }
        }

    }

}