package com.example.myapplication.data

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book
import com.example.myapplication.data.net.BookCloud
import com.example.myapplication.domain.BookDomain

sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>() {
    class Success(private val fetchBooks: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain = mapper.map(fetchBooks)
    }

    class Fail(private val e: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain = mapper.map(e)
    }
}