package com.example.read.presentation.screen.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.read.commons.AppColors

@Preview
@Composable
fun StatsSection(
    bookCount: Int = 15,
    avgRating: Double = 4.3,
) {

    Column(

    ) {
        Text(
            text = "BOOKS: $bookCount",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = Italic,
            fontSize = 46.sp,
            fontFamily = FontFamily.SansSerif,
            color = AppColors.mTextWhite
        )

        Text(
            text = "AVG RATING: $avgRating",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = Italic,
            fontSize = 46.sp,
            fontFamily = FontFamily.SansSerif,
            color = AppColors.mTextWhite
        )
    }

}