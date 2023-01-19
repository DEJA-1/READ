package com.example.read.presentation.screen.login.components

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.read.commons.AppColors
import com.google.common.io.Files.append

@Preview
@Composable
fun RegisterText() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = AppColors.mTextWhite
                )
            ) {
                append("You're new? ")
            }

            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 16.sp,
                    color = AppColors.mMain
                )
            ) {
                append("Sing up")

            }
        },
        modifier = Modifier.clickable {  }
    )
}