package com.example.read.presentation.screen.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.read.commons.Resource
import com.example.read.domain.model.MyCategory
import com.example.read.domain.model.MyItem
import com.example.read.domain.model.MyItems
import com.example.read.domain.model.loadCategories
import com.example.read.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: BookRepository,
) : ViewModel() {
    init {
        getAllBooks("business")
    }

    val categoryList: List<MyCategory> = loadCategories()

    private val _isLoading = mutableStateOf(true)
    val isLoading = _isLoading

    private val errorMessage = mutableStateOf("")
    val bookList = mutableStateOf(MyItems(listOf()))

    fun getAllBooks(searchQuery: String) {
        viewModelScope.launch {
            val result = repository.getBooks(searchQuery)

            if (searchQuery.isEmpty()) {
                return@launch
            }

            when (result) {
                is Resource.Success -> {
                    bookList.value = result.data!!
                    _isLoading.value = false
                }

                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    _isLoading.value = false
                }

                else -> {}
            }
        }
    }

    fun changeLoadingState() {
        _isLoading.value = !_isLoading.value
    }
}