package com.example.read.presentation.screen.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.read.commons.AppColors

@Composable
fun YourCollectionSection() {

    Column() {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Your collection",
            color = AppColors.mTextWhite,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Normal,
            fontSize = 32.sp,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(20.dp))

        BookRow(
            shapeDp = 360,
            heightSize = 125,
            widthSize = 125,
            isForYou = true
        ) {

        }
    }

}