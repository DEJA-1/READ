package com.example.read.presentation.screen.search.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.read.presentation.common_components.TextInputField

@Composable
fun SearchBar(
    onClick: (String) -> Unit
) {

    val search = remember {
        mutableStateOf("")
    }

    TextInputField(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp),
        valueState = search,
        label = "Search",
        imeAction = ImeAction.Done,
        onAction = KeyboardActions(
            onDone = { onClick(search.value) }
        )
    ) {

    }
}