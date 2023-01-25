package com.example.read.data.network

import com.example.read.data.network.response.Item
import com.example.read.data.network.response.Response
import com.example.read.domain.model.MyItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ReadApi {

    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String) : Response

    @GET("volumes/{bookId}")
    suspend fun getBookById(@Path("bookId") bookId: String) : Item
}