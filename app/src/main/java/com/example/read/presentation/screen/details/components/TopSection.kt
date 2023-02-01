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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.read.commons.AppColors
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.MyItem
import com.example.read.presentation.common_components.MyButton
import com.example.read.presentation.screen.details.DetailsViewModel
import com.example.read.presentation.screen.home.HomeViewModel
import com.example.read.util.isValid
import com.google.firebase.auth.FirebaseAuth

@Composable
fun TopSection(
    context: Context,
    book: BookFB,
    navController: NavController,
    viewModel: DetailsViewModel,
    homeViewModel: HomeViewModel = hiltViewModel(),
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
                            if (isValid(book.image))
                                book.image
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
                        text = book.title.toString(),
                        color = AppColors.mTextWhite,
                        fontWeight = FontWeight.ExtraBold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 3
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 2.dp),
                        text = if (isValid(book.authors)) "${book.authors}" else "Unknown",
                        color = AppColors.mTextWhite,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 1,
                        overflow = TextOverflow.Clip
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 2.dp),
                        text = if (isValid(book.publishedDate)) book.publishedDate.toString() else "Unknown",
                        color = AppColors.mTextWhite,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 1,
                        overflow = TextOverflow.Clip

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
                                title = book.title,
                                authors = book.authors.toString(),
                                categories = book.categories.toString(),
                                description = book.description,
                                pageCount = book.pageCount,
                                image = book.image,
                                publishedDate = book.publishedDate,
                                rating = 0.0,
                                read = false,
                                bookId = book.id,
                                userId = FirebaseAuth.getInstance().currentUser?.uid.toString()
                            )
                            viewModel.addToFirebase(bookFb)
                            Toast.makeText(context, "Book added successfully", Toast.LENGTH_SHORT)
                                .show()
                            homeViewModel.getBooksFromFB()
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
                        text = if (isValid(book.description)) book.description.toString() else "There is no description for this book.",
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