package com.example.read.presentation.screen.search.components

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.read.commons.AppColors
import com.example.read.domain.model.MyItem
import com.example.read.presentation.screen.search.SearchViewModel
import com.example.read.util.isValid

@Composable
fun SearchBookRow(
    book: MyItem,
    context: Context,
) {

    val isExpanded = remember {
        mutableStateOf(false)
    }
    Surface(
        elevation = 6.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color(0xFF3B3A3A))

            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.03f)
                        .background(AppColors.mMain)
                        .align(Alignment.BottomCenter)
                )

                Row(modifier = Modifier.fillMaxWidth()) {
                    Surface(
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 8.dp,
                            bottom = 13.dp
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth(0.25f)
                                .fillMaxHeight()
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
                            contentDescription = "Book image",
                            contentScale = ContentScale.FillBounds
                        )
                    }

                    Column() {
                        Text(
                            modifier = Modifier.padding(top = 2.dp, end = 4.dp),
                            text = book.volumeInfo?.title.toString(),
                            color = AppColors.mTextWhite,
                            fontWeight = FontWeight.ExtraBold,
                            fontStyle = FontStyle.Italic,
                            fontSize = 26.sp,
                            textAlign = TextAlign.Start,
                            maxLines = 2
                        )

                        Text(
                            text = if (isValid(book.volumeInfo?.authors?.first())) "Author: ${book.volumeInfo?.authors?.first()}" else "Author: unknown",
                            color = Color.LightGray,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = if(isValid(book.volumeInfo?.categories?.first())) "Category: ${book.volumeInfo?.categories?.first()}" else "Category: unknown",
                            color = Color.LightGray,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = "Pages: ${book.volumeInfo?.pageCount}",
                            color = Color.LightGray,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Start
                        )

                    }
                }

                Icon(
                    modifier = Modifier
                        .size(34.dp)
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 6.dp)
                        .clickable {
                            isExpanded.value = !isExpanded.value
                        },
                    imageVector = Icons.Filled.ArrowDownward,
                    contentDescription = "arrow images",
                    tint = Color.LightGray
                )
            }

            AnimatedVisibility(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppColors.mMain),
                visible = isExpanded.value
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = if (book.volumeInfo?.description.isNullOrEmpty()) "There is no description for this book" else book.volumeInfo?.description.toString(),
                    color = AppColors.mBackgroundSec,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Start
                )
            }
        }

    }

}