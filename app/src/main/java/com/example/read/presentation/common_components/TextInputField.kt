package com.example.read.presentation.common_components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
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
    unfocusedBorderColor: Color = Color.LightGray,
    unfocusedLabelColor: Color = Color.LightGray,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
    isPassword: Boolean = false,
    shape: RoundedCornerShape = RoundedCornerShape(6.dp),
    trailingIcon: @Composable() () -> Unit
) {
    val visualTransformation = if (isPassword)
        PasswordVisualTransformation()
    else
        VisualTransformation.None

    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        modifier = modifier,
        singleLine = isSingleLane,
        trailingIcon = trailingIcon,
        enabled = enabled,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = focusedBorderColor,
            focusedLabelColor = focusedLabelColor,
            unfocusedBorderColor = unfocusedBorderColor,
            unfocusedLabelColor = unfocusedLabelColor,
            cursorColor = AppColors.mMain
        ),
        shape = shape,
        textStyle = TextStyle(color = AppColors.mTextWhite),
        visualTransformation = visualTransformation
    )
}