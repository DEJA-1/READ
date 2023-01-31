package com.example.read.presentation.screen.home

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.read.domain.model.BookFB
import com.example.read.domain.repository.FirebaseRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: FirebaseRepository
): ViewModel() {
    private val _isLoading = mutableStateOf(true)
    val isLoading = _isLoading

    private val _booksFromFB = mutableStateOf(listOf<BookFB>())
    val booksFromFB = _booksFromFB

    init {
        getBooksFromFB()
    }

    fun getBooksFromFB() {
        viewModelScope.launch {
            _isLoading.value = true
            _booksFromFB.value = repository.getBooksFromFB().data!!

            if (_booksFromFB.value.isNotEmpty())
                _isLoading.value = false
        }
    }

    fun updateBook(book: BookFB, isRead: Boolean, context: Context) {

        val bookUpdate = hashMapOf(
            "read" to isRead
        ).toMap()

        FirebaseFirestore.getInstance()
            .collection("books")
            .document(book.id!!)
            .update(bookUpdate)
            .addOnCompleteListener {
                Toast.makeText(context, "Book updated", Toast.LENGTH_SHORT).show()
            }
    }

}