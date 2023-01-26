package com.example.read.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.read.domain.model.MyItem

class CommonViewModel: ViewModel() {

    private val _currentBook = mutableStateOf(MyItem(null, null, null))
    val currentBook = _currentBook

    fun updateCurrentBook(book: MyItem) {
        _currentBook.value = book
    }
}