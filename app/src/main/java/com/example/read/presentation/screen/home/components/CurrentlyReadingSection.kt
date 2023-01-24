package com.example.read.presentation.screen.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.read.commons.AppColors

@Preview
@Composable
fun CurrentlyReadingSection() {

    Column(
        modifier = Modifier.padding(bottom = 8.dp)
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

        BookRow()
    }
}