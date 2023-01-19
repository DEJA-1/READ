package com.example.read.presentation.common_components

import android.util.Log
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.read.commons.AppColors

@Composable
fun TextInputField(
    valueState: MutableState<String>,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isSingleLane: Boolean = true,
    label: String,
    focusedBorderColor: Color = AppColors.mMain,
    focusedLabelColor: Color = AppColors.mMain,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
    isPassword: Boolean = false
    ) {

    val visualTransformation = if(isPassword)
        PasswordVisualTransformation()
    else
        VisualTransformation.None

    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        modifier = modifier,
        singleLine = isSingleLane,
        enabled = enabled,
        label = { Text(text = label)},
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = focusedBorderColor,
            focusedLabelColor = focusedLabelColor,
            unfocusedBorderColor = Color.LightGray,
            unfocusedLabelColor = Color.LightGray,
            cursorColor = AppColors.mMain
        ),
        textStyle = TextStyle(color = AppColors.mTextWhite),
        visualTransformation = visualTransformation
    )
}