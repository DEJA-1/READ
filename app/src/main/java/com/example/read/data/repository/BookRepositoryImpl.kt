package com.example.read.data.repository

import com.example.read.commons.Resource
import com.example.read.data.network.ReadApi
import com.example.read.data.network.response.toMyItems
import com.example.read.domain.model.MyItems
import com.example.read.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val api: ReadApi
) : BookRepository {

    override suspend fun getBooks(searchQuery: String): Resource<MyItems> {

        return try {
            Resource.Loading(true)
            val response = api.getBooks(searchQuery).toMyItems()

            if (response.items.isNotEmpty())
                Resource.Loading(false)
            Resource.Success(response)

        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }

}