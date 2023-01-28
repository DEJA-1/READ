package com.example.read.di

import com.example.read.commons.Constants
import com.example.read.data.network.ReadApi
import com.example.read.data.repository.BookRepositoryImpl
import com.example.read.data.repository.FirebaseRepositoryImpl
import com.example.read.domain.repository.BookRepository
import com.example.read.domain.repository.FirebaseRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideReadApi(): ReadApi {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ReadApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBookRepository(api: ReadApi) : BookRepository {
        return BookRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideFirebaseRepository() : FirebaseRepository {
        return FirebaseRepositoryImpl(queryBook = FirebaseFirestore.getInstance().collection("books"))
    }

}