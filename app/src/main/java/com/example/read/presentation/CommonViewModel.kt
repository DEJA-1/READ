package com.example.read.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.MyItem

class CommonViewModel: ViewModel() {

    private val _currentBook = mutableStateOf(BookFB())
    val currentBook = _currentBook

    fun updateCurrentBook(book: BookFB) {
        _currentBook.value = book
    }
}