package com.example.read.presentation

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.MyItem
import com.example.read.domain.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor(
    private val repository: FirebaseRepository
): ViewModel() {

    private val _currentBook = mutableStateOf(BookFB())
    val currentBook = _currentBook

    fun updateCurrentBook(book: BookFB) {
        _currentBook.value = book
    }

    fun updateBookRead(book: BookFB, isRead: Boolean, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBookRead(book, isRead, context)
        }
    }

    fun updateBookRate(book: BookFB, isRated: Boolean, rating: Int, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBookRate(book, isRated, rating, context)
        }
    }

    fun updateBookNote(book: BookFB, note: String, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBookNote(book, note, context)
        }
    }
}