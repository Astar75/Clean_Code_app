package com.example.myapplication.data

import com.example.myapplication.data.net.BookCloud
import com.example.myapplication.data.net.BooksService

interface BooksCloudDataSource {
    suspend fun fetchBooks(): List<BookCloud>

    class Base(private val service: BooksService): BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookCloud> = service.fetchBooks()
    }
}