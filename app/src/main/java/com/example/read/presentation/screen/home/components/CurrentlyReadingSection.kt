package com.example.read.presentation.screen.home.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.read.commons.AppColors

@Preview
@Composable
fun CurrentlyReadingSection(context: Context = LocalContext.current) {

    Column(
        modifier = Modifier.padding()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Currently reading",
            color = AppColors.mTextWhite,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        BookRow() {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red),
                contentAlignment = Center
            ) {

                AsyncImage(
                    modifier = Modifier.fillMaxSize(0.6f).clip(RoundedCornerShape(12.dp)),
                    model = ImageRequest.Builder(context)
                        .data("http://books.google.com/books/content?id=pZ5iAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Book image"
                )

            }



//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(0.3f)
//                    .background(AppColors.mMain)
//            )


        }
    }
}