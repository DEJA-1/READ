package com.example.read.presentation.screen.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.read.commons.AppColors
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.MyCategory
import com.example.read.domain.model.MyItem

@Composable
fun BookRow(
    modifier: Modifier = Modifier,
    book: BookFB = BookFB(),
    category: MyCategory = MyCategory("", ""),
    shapeDp: Int = 12,
    heightSize: Int = 170,
    widthSize: Int = 120,
    isForYou: Boolean = false,
    isYourCollection: Boolean = false,
    onItemClicked: () -> Unit = {},
    content: @Composable() () -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = if (isYourCollection) Modifier.widthIn(max = widthSize.dp) else Modifier.fillMaxWidth()
    ) {
        Surface(
            shape = RoundedCornerShape(shapeDp.dp),
            elevation = 4.dp,
            modifier = modifier.border(2.dp, color = Color.Black, shape = RoundedCornerShape(shapeDp.dp))
        ) {
            Box(
                modifier = Modifier
                    .clickable {
                        onItemClicked()
                    }
                    .height(heightSize.dp)
                    .width(widthSize.dp)
                    .background(AppColors.mBackgroundSec))
            {
                content()
            }
        }

        if (isYourCollection) {

                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = book.title.toString(),
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 14.sp,
                    color = AppColors.mTextWhite,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    overflow = TextOverflow.Clip
                )

        }

        if (isForYou) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = category.name,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 18.sp,
                color = AppColors.mTextWhite,
                textAlign = TextAlign.Center,
                maxLines = 3,
                overflow = TextOverflow.Clip
            )
        }
    }
}