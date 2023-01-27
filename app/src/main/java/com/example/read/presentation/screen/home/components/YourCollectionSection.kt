package com.example.read.presentation.screen.home.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
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
import com.example.read.navigation.Screen

@Composable
fun YourCollectionSection(
    context: Context = LocalContext.current,
    navController: NavController,
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

        BookRow(
            shapeDp = 12,
            heightSize = 150,
            widthSize = 105,
            isYourCollection = true,
            onItemClicked = { navController.navigate(Screen.Rate.route) }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {

                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize(),
                    model = ImageRequest.Builder(context)
                        .data("http://books.google.com/books/content?id=pZ5iAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Book image"
                )

                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.1f).background(AppColors.mGreen))
            }

        }
    }

}