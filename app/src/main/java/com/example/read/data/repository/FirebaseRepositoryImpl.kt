package com.example.read.data.repository

import android.util.Log
import com.example.read.domain.model.BookFB
import com.example.read.domain.repository.FirebaseRepository
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseRepositoryImpl : FirebaseRepository {
    override suspend fun addToFirebase(book: BookFB) {
        val database = FirebaseFirestore.getInstance().collection("books")

        if (book.toString().isNotEmpty()) {
            database.add(book)
                .addOnSuccessListener { documentRef ->

                    val documentId = documentRef.id
                    database.document(documentId)
                        .update(hashMapOf("id" to documentId) as Map<String, Any>)

                        .addOnFailureListener {
                            Log.w("Error", "AddToFirebase: Failed updating doc", it)
                        }
                }
        }
    }
}