package com.example.read.presentation.screen.profile.components

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.read.commons.AppColors
import com.example.read.domain.model.BookFB
import com.example.read.navigation.Screen
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.screen.home.components.BookRow

@Composable
fun YourFavoritesSection(
    modifier: Modifier = Modifier,
    bookList: List<BookFB>,
    commonViewModel: CommonViewModel,
    navController: NavController,
    context: Context,
) {
    LazyRow() {
        items(bookList) { book ->
            BookRow(
                modifier = modifier.padding(4.dp),
                shapeDp = 12,
                heightSize = 150,
                widthSize = 110,
                book = book,
                onItemClicked = {
                    commonViewModel.updateCurrentBook(book)
                    navController.navigate(Screen.Rate.route)
                }
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = ImageRequest.Builder(context)
                            .data(book.image)
                            .crossfade(true)
                            .build(),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "Book image"
                    )

                }

            }

        }
    }

}


