package com.example.read.presentation.screen.details.components

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.read.commons.AppColors
import com.example.read.domain.model.MyItem
import com.example.read.presentation.common_components.MyButton
import com.example.read.util.isValid

@Composable
fun TopSection(
    context: Context,
    book: MyItem,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)

    ) {

        Column() {

            Row() {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth(0.55f)
                        .fillMaxHeight(0.45f)
                        .border(2.dp, Color.Black),
                    model = ImageRequest.Builder(context)
                        .data(
                            if (isValid(book.volumeInfo?.imageLinks?.thumbnail))
                                book.volumeInfo?.imageLinks?.thumbnail
                            else
                                com.example.read.R.drawable.imagenotfound
                        )
                        .crossfade(true)
                        .build(),
                    contentDescription = "Book image",
                    contentScale = ContentScale.FillBounds
                )

                Column {
                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        text = book.volumeInfo?.title.toString(),
                        color = AppColors.mTextWhite,
                        fontWeight = FontWeight.ExtraBold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 2
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 2.dp),
                        text = if (isValid(book.volumeInfo?.authors?.first())) "${book.volumeInfo?.authors?.first()}" else "Unknown",
                        color = AppColors.mTextWhite,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 1
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 2.dp),
                        text = if (isValid(book.volumeInfo?.publishedDate)) book.volumeInfo?.publishedDate.toString() else "Unknown",
                        color = AppColors.mTextWhite,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 1
                    )

                    Spacer(modifier = Modifier.height(60.dp))

                    MyButton(
                        text = "SAVE",
                        contentPadding = 8,
                        modifier = Modifier.padding(
                            top = 8.dp,
                            bottom = 8.dp,
                            end = 8.dp,
                            start = 16.dp
                        )
                    ) {

                    }
                    MyButton(
                        text = "CANCEL",
                        contentPadding = 8,
                        modifier = Modifier.padding(
                            top = 8.dp,
                            bottom = 8.dp,
                            end = 8.dp,
                            start = 16.dp
                        )
                    ) {
                        navController.popBackStack()
                    }

                }
            }

            LazyColumn() {
                item {
                    Text(
                        modifier = Modifier.padding(
                            start = 4.dp,
                            bottom = 4.dp,
                            end = 4.dp,
                            top = 16.dp
                        ),
                        text = book.volumeInfo?.description.toString(),
                        color = AppColors.mTextWhite,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 18.sp
                    )
                }
            }

        }
    }

}