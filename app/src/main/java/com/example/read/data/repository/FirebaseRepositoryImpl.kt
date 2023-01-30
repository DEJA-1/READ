package com.example.read.data.repository

import android.util.Log
import com.example.read.commons.Resource
import com.example.read.domain.model.BookFB
import com.example.read.domain.repository.FirebaseRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    private val queryBook: CollectionReference
): FirebaseRepository {
    override suspend fun addToFirebase(book: BookFB) {

        if (book.toString().isNotEmpty()) {
            queryBook.add(book)
                .addOnSuccessListener { documentRef ->

                    val documentId = documentRef.id
                    queryBook.document(documentId)
                        .update(hashMapOf("id" to documentId) as Map<String, Any>)

                        .addOnFailureListener {
                            Log.w("Error", "AddToFirebase: Failed updating doc", it)
                        }
                }
        }
    }
    override suspend fun getBooksFromFB(): Resource<List<BookFB>> {
        return try {
            Resource.Loading(true)

            val response = queryBook.get().await().documents.map { documentSnapshot ->
                documentSnapshot.toObject(BookFB::class.java)!!
            }
            if (response.isNotEmpty())
                Resource.Loading(false)
            Resource.Success(response)
        } catch (exception: FirebaseFirestoreException) {
            Resource.Error(exception.message.toString())
        }
    }
}