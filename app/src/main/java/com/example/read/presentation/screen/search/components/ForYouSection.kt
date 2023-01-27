package com.example.read.presentation.screen.search.components

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.read.commons.AppColors
import com.example.read.domain.model.MyCategory
import com.example.read.presentation.screen.home.components.BookRow

@Composable
fun ForYouSection(
    context: Context,
    categoryList: List<MyCategory>,
    onClick: (String) -> Unit
) {

    Text(
        modifier = Modifier.padding(top = 4.dp, end = 4.dp, bottom = 16.dp, start = 10.dp),
        text = "For you",
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontSize = 24.sp,
        color = AppColors.mTextWhite,
        textAlign = TextAlign.Start
    )

    LazyRow() {
        items(categoryList) { category ->
            BookRow(
                modifier = Modifier.padding(4.dp),
                category = category,
                heightSize = 125,
                widthSize = 125,
                shapeDp = 360,
                isForYou = true,
                onItemClicked = {
                    onClick(category.name)
                }
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(category.image)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "category Image"
                )
            }
        }

    }

}