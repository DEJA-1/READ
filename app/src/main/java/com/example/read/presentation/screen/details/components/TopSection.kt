package com.example.read.presentation.screen.details.components

import android.content.Context
import android.widget.Toast
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
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.MyItem
import com.example.read.presentation.common_components.MyButton
import com.example.read.presentation.screen.details.DetailsViewModel
import com.example.read.util.isValid
import com.google.firebase.auth.FirebaseAuth

@Composable
fun TopSection(
    context: Context,
    book: MyItem,
    navController: NavController,
    viewModel: DetailsViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)

    ) {

        Column() {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.45f)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth(0.55f)
                        .fillMaxHeight()
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
                        fontSize = 26.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 3
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 2.dp),
                        text = if (isValid(book.volumeInfo?.authors?.first())) "${book.volumeInfo?.authors?.first()}" else "Unknown",
                        color = AppColors.mTextWhite,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 1
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 2.dp),
                        text = if (isValid(book.volumeInfo?.publishedDate)) book.volumeInfo?.publishedDate.toString() else "Unknown",
                        color = AppColors.mTextWhite,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 1
                    )

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        MyButton(
                            text = "SAVE",
                            contentPadding = 8,
                            modifier = Modifier.padding(
                                bottom = 8.dp,
                                end = 8.dp,
                                start = 16.dp
                            )

                        ) {
                            val bookFb: BookFB = BookFB(
                                title = book.volumeInfo?.title,
                                authors = book.volumeInfo?.authors.toString(),
                                categories = book.volumeInfo?.categories.toString(),
                                description = book.volumeInfo?.description,
                                pageCount = book.volumeInfo?.pageCount,
                                image = book.volumeInfo?.imageLinks?.thumbnail,
                                publishedDate = book.volumeInfo?.publishedDate,
                                rating = 0.0,
                                bookId = book.id,
                                userId = FirebaseAuth.getInstance().currentUser?.uid.toString()
                            )
                            viewModel.addToFirebase(bookFb)
                            Toast.makeText(context, "Book added successfully", Toast.LENGTH_SHORT)
                                .show()
                            navController.popBackStack()
                        }
                        MyButton(
                            text = "CANCEL",
                            contentPadding = 8,
                            modifier = Modifier.padding(
                                bottom = 16.dp,
                                end = 8.dp,
                                start = 16.dp
                            )
                        ) {
                            navController.popBackStack()
                        }

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
                        text = if (isValid(book.volumeInfo?.description)) book.volumeInfo?.description.toString() else "There is no description for this book.",
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