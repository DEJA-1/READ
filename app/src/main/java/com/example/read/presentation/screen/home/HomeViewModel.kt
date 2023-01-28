package com.example.read.presentation.screen.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.read.data.repository.FirebaseRepositoryImpl
import com.example.read.domain.model.BookFB
import com.example.read.domain.repository.FirebaseRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: FirebaseRepository
): ViewModel() {

    private val _booksFromFB = mutableStateOf(listOf<BookFB>())
    val booksFromFB = _booksFromFB
    private val _isLoading = mutableStateOf(true)
    val isLoading = _isLoading

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

}