package com.example.read.domain.repository

import android.content.Context
import android.widget.Toast
import com.example.read.commons.Resource
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.MyItem

interface FirebaseRepository {

    suspend fun addToFirebase(book: BookFB, toastFailure: Toast, toastSuccess: Toast)
    suspend fun getBooksFromFB(): Resource<List<BookFB>>

    suspend fun updateBookRead(book: BookFB, isRead: Boolean, context: Context)
    suspend fun updateBookRate(book: BookFB, isRated: Boolean, context: Context)
}