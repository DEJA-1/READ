package com.example.read.presentation.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.read.domain.model.BookFB
import com.example.read.domain.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    val repository: FirebaseRepository
) : ViewModel() {

    fun addToFirebase(book: BookFB) = viewModelScope.launch {
        repository.addToFirebase(book)
    }
}