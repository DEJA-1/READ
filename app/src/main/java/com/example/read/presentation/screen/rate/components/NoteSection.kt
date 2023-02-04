package com.example.read.presentation.screen.rate.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.read.commons.AppColors
import com.example.read.presentation.common_components.TextInputField

@Composable
fun NoteSection(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    onDone: () -> Unit = {},
) {

    TextInputField(
        modifier = modifier,
        valueState = valueState,
        label = "Note",
        isSingleLane = false,
        shape = RoundedCornerShape(24.dp),
        onAction = KeyboardActions {
            onDone()
        }
    ) {

        Icon(
            modifier = Modifier
                .clickable {
                    valueState.value = ""
                },
            imageVector = Icons.Filled.Cancel,
            contentDescription = "cancel icon",
            tint = AppColors.mMain
        )
    }

}