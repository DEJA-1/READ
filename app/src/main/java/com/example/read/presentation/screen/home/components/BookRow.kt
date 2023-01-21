package com.example.read.presentation.screen.home.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.read.commons.AppColors
import com.example.read.util.gradient

@Preview
@Composable
fun BookRow(
    shapeDp: Int = 12
) {

    Card(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp),
        shape = RoundedCornerShape(shapeDp.dp),
        elevation = 4.dp,
        backgroundColor = AppColors.mBackgroundSec
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)) {

            Box(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(0.3f)
                    .background(gradient(colors = listOf(AppColors.mMain, AppColors.mForGradient)))
            )
        }
    }

}