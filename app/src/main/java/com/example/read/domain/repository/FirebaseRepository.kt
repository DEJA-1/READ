package com.example.read.domain.repository

import android.widget.Toast
import com.example.read.commons.Resource
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.MyItem

interface FirebaseRepository {

    suspend fun addToFirebase(book: BookFB, toastFailure: Toast, toastSuccess: Toast)

    suspend fun getBooksFromFB(): Resource<List<BookFB>>
}