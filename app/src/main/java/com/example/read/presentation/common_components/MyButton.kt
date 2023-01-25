package com.example.read.presentation.common_components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.read.commons.AppColors
import com.example.read.presentation.screen.login.LoginViewModel
import com.example.read.util.gradient

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    text: String = "CONTINUE",
    fontSize: Int = 24,
    onButtonClicked: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onButtonClicked()
            }
            .background(AppColors.mMain)
            .clip(RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(15.dp),
            text = text,
            color = AppColors.mTextWhite,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = fontSize.sp
        )
    }
}