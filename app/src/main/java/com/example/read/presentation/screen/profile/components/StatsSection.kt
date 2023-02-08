package com.example.read.presentation.screen.profile.components

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.read.commons.AppColors
import com.example.read.presentation.CommonViewModel

@Composable
fun StatsSection(
    bookCount: Int,
    ratingAvg: Double,
    category: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "BOOKS",
                fontWeight = FontWeight.ExtraBold,
                fontStyle = Italic,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                color = AppColors.mTextWhite,
                textAlign = TextAlign.Center
            )

            Text(
                text = bookCount.toString(),
                fontWeight = FontWeight.ExtraBold,
                fontStyle = Italic,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                color = AppColors.mMain,
                textAlign = TextAlign.Center
            )
        }

        Divider(
            modifier = Modifier.padding(8.dp),
            color = Color.DarkGray,
            thickness = 2.dp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "AVG RATING",
                fontWeight = FontWeight.ExtraBold,
                fontStyle = Italic,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                color = AppColors.mTextWhite,
                textAlign = TextAlign.Center
            )

            Text(
                text = ratingAvg.toString(),
                fontWeight = FontWeight.ExtraBold,
                fontStyle = Italic,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                color = AppColors.mMain,
                textAlign = TextAlign.Center
            )
        }

        Divider(
            modifier = Modifier.padding(8.dp),
            color = Color.DarkGray,
            thickness = 2.dp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "FAV CATEGORY",
                fontWeight = FontWeight.ExtraBold,
                fontStyle = Italic,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                color = AppColors.mTextWhite,
                textAlign = TextAlign.Center,
            )

            Text(
                text = if (category.trim('[', ']') == "null") "Unknown" else category.trim('[', ']'),
                fontWeight = FontWeight.ExtraBold,
                fontStyle = Italic,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                color = AppColors.mMain,
                textAlign = TextAlign.Center
            )
        }

        Divider(
            modifier = Modifier.padding(8.dp),
            color = Color.DarkGray,
            thickness = 2.dp
        )

    }

}