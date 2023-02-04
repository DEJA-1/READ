package com.example.read.data.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
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
) : FirebaseRepository {
    override suspend fun addToFirebase(book: BookFB, toastFailure: Toast, toastSuccess: Toast) {

        if (book.toString().isNotEmpty()) {
            queryBook.whereEqualTo("title", book.title)
                .get()
                .addOnSuccessListener { querySnapshot ->
                    if (querySnapshot.isEmpty) {
                        queryBook.add(book)
                            .addOnSuccessListener { documentRef ->

                                val documentId = documentRef.id
                                queryBook.document(documentId)
                                    .update(hashMapOf("id" to documentId) as Map<String, Any>)

                                    .addOnFailureListener {
                                        Log.w("Error", "AddToFirebase: Failed updating doc", it)
                                    }
                                toastSuccess.show()
                            }
                    } else {
                        toastFailure.show()
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
            Resource.Loading(false)
            Resource.Success(response)

        } catch (exception: FirebaseFirestoreException) {
            Resource.Error(exception.message.toString())
        }
    }

    override suspend fun updateBookRead(book: BookFB, isRead: Boolean, context: Context) {
        val bookUpdate = hashMapOf(
            "read" to isRead
        ).toMap()

        book.id?.let {
            FirebaseFirestore.getInstance()
                .collection("books")
                .document(it)
                .update(bookUpdate)
                .addOnCompleteListener {
                    Toast.makeText(context, "Book updated", Toast.LENGTH_SHORT).show()
                }
        }

    }

    override suspend fun updateBookRate(book: BookFB, isRated: Boolean, rating: Int, context: Context) {
        val bookUpdate = hashMapOf(
            "rated" to isRated,
            "rating" to rating
        ).toMap()

        book.id?.let {
            FirebaseFirestore.getInstance()
                .collection("books")
                .document(it)
                .update(bookUpdate)
                .addOnCompleteListener {
                    Toast.makeText(context, "Book updated", Toast.LENGTH_SHORT).show()
                }
        }
    }

    override suspend fun updateBookNote(book: BookFB, note: String, context: Context) {
        val bookUpdate = hashMapOf(
            "note" to note
        ).toMap()

        book.id?.let {
            FirebaseFirestore.getInstance()
                .collection("books")
                .document(it)
                .update(bookUpdate)
                .addOnCompleteListener {
                    Toast.makeText(context, "Book updated", Toast.LENGTH_SHORT).show()
                }
        }

    }

}