package com.example.read.presentation.screen.home.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.read.commons.AppColors
import com.example.read.util.gradient

@Composable
fun BookRow(
    shapeDp: Int = 12,
    heightSize: Int = 200,
    widthSize: Int = 150,
    isForYou: Boolean = false,
    onItemClicked: () -> Unit = {},
    content: @Composable() () -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.widthIn(max = widthSize.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(shapeDp.dp))
                .clickable {
                    onItemClicked()
                }
                .height(heightSize.dp)
                .width(widthSize.dp)
                .background(AppColors.mBackgroundSec)

        ) {
            content()
        }

        if (isForYou) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "asdifsdfji s jisdfjisi jiosd fiojsiodsf ijs",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 14.sp,
                    color = AppColors.mTextWhite,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    overflow = TextOverflow.Clip
                )

                Row() {
                    Text(
                        text = "5",
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic,
                        fontSize = 16.sp,
                        color = AppColors.mTextWhite,
                        textAlign = TextAlign.Center

                    )

                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "star icon",
                        tint = AppColors.mMain,
                        modifier = Modifier.size(22.dp)
                    )
                }

            }
        }
    }
}