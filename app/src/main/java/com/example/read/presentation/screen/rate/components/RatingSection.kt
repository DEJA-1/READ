package com.example.read.presentation.screen.rate.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.read.commons.AppColors

@Composable
fun RatingSection(
    rate: MutableState<Int>,
) {

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "RATING: ${rate.value}",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = AppColors.mTextWhite,
            )

            Icon(
                modifier = Modifier.size(48.dp),
                imageVector = Icons.Filled.Star,
                contentDescription = "Star Icon",
                tint = AppColors.mMain
            )
        }

        Row() {
            Icon(
                modifier = Modifier
                    .size(54.dp)
                    .clickable {
                        if (rate.value < 5)
                            rate.value++
                    },
                imageVector = Icons.Filled.AddCircle,
                contentDescription = "Circle Icon",
                tint = AppColors.mGreen
            )
            Icon(
                modifier = Modifier
                    .size(54.dp)
                    .clickable {
                        if (rate.value > 1)
                            rate.value--
                    },
                imageVector = Icons.Filled.RemoveCircle,
                contentDescription = "Circle Icon",
                tint = AppColors.mRed
            )
        }
    }

}