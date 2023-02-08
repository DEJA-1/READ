package com.example.read.presentation.screen.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.read.commons.Resource
import com.example.read.domain.model.Achievement
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.loadAchievements
import com.example.read.domain.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: FirebaseRepository,
) : ViewModel() {
    private val _isLoadingBooks = mutableStateOf(true)
    val isLoadingBooks = _isLoadingBooks

    private val _booksFromFB = mutableStateOf(listOf<BookFB>())
    val booksFromFB = _booksFromFB


    private val _isLoadingAchievements = mutableStateOf(true)
    val isLoadingAchievements = _isLoadingAchievements

    private val _achievementsFromFB = mutableStateOf(listOf<Achievement>())
    val achievementsFromFB = _achievementsFromFB

    private val errorMessageBooks = mutableStateOf("")

    private val errorMessageAchievements = mutableStateOf("")
    init {
        getBooksFromFB()
        getAchievementsFromFb()
    }

    private fun getBooksFromFB() {
        viewModelScope.launch {
            delay(200L)
            _isLoadingBooks.value = true
            val result = repository.getBooksFromFB()

            when (result) {
                is Resource.Success -> {
                    _booksFromFB.value = result.data!!
                    _isLoadingBooks.value = false
                }

                is Resource.Error -> {
                    errorMessageBooks.value = result.message!!
                    _isLoadingBooks.value = false
                }

                else -> {}
            }
        }
    }

    private fun getAchievementsFromFb() {
        viewModelScope.launch {
            _isLoadingAchievements.value = true
            val result = repository.getAchievementsFromFB()

            when (result) {
                is Resource.Success -> {
                    _achievementsFromFB.value = result.data!!
                    _isLoadingAchievements.value = false
                }

                is Resource.Error -> {
                    errorMessageAchievements.value = result.message!!
                    _isLoadingAchievements.value = false
                }

                else -> {}
            }
        }
    }

}