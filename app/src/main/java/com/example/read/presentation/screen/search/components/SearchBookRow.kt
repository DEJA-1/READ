package com.example.read.presentation.screen.search.components

import android.content.Context
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

@Composable
fun SearchBookRow(
    context: Context,
    onArrowClicked: () -> Unit = {},
) {

    Surface(
        elevation = 6.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(AppColors.mBackgroundSec)

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.05f)
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
                            .data("http://books.google.com/books/content?id=pZ5iAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
                            .crossfade(true)
                            .build(),
                        contentDescription = "Book image",
                        contentScale = ContentScale.FillBounds
                    )
                }

                Column() {
                    Text(
                        text = "THE GREAT PYRAMID OF GIZA",
                        color = AppColors.mTextWhite,
                        fontWeight = FontWeight.ExtraBold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "Author: Your mother",
                        color = Color.LightGray,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "Category: Business",
                        color = Color.LightGray,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "Pages: 333",
                        color = Color.LightGray,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        fontSize = 13.sp,
//                        textAlign = TextAlign.Start
                    )

                }
            }

            Icon(
                modifier = Modifier
                    .size(34.dp)
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 6.dp)
                    .clickable {
                        onArrowClicked()
                    },
                imageVector = Icons.Filled.ArrowDownward,
                contentDescription = "arrow images",
                tint = Color.LightGray
            )
        }
    }

}