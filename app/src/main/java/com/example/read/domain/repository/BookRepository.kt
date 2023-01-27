package com.example.read.domain.repository

import com.example.read.commons.Resource
import com.example.read.domain.model.MyItems

interface BookRepository  {
    suspend fun getBooks(searchQuery: String) : Resource<MyItems>
}