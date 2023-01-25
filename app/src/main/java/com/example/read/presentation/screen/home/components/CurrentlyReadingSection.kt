package com.example.read.presentation.screen.home.components

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.read.commons.AppColors
import com.example.read.presentation.common_components.MyButton

@Preview
@Composable
fun CurrentlyReadingSection(context: Context = LocalContext.current) {

    val isCardExpanded = remember {
        mutableStateOf(false)
    }

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

        BookRow(
            onItemClicked = { isCardExpanded.value = !isCardExpanded.value }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppColors.mBackgroundSec),
                contentAlignment = Center
            ) {
                Row() {
                    AnimatedVisibility(visible = isCardExpanded.value) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Center
                        ) {
                            MyButton(
                                modifier = Modifier.fillMaxWidth(0.7f)
                                    .fillMaxHeight(0.2f)
                                    .clip(RoundedCornerShape(12.dp)),
                                text = "MARK AS READ",
                                fontSize = 8
                            )
                        }

                    }
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 4.dp,
                                shape = RoundedCornerShape(12.dp),
                                color = Color(0xFF621708)
                            )
                            .clip(RoundedCornerShape(12.dp)),
                        model = ImageRequest.Builder(context)
                            .data("http://books.google.com/books/content?id=pZ5iAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
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