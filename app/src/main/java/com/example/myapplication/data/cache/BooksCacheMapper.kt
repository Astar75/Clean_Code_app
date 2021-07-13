package com.example.myapplication.data.cache

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book

interface BooksCacheMapper : Abstract.Mapper {
    fun map(booksDb: List<BookDb>): List<Book>

    class Base(private val mapper: BookCacheMapper) : BooksCacheMapper {
        override fun map(books: List<BookDb>): List<Book> = books.map { bookDb ->
            bookDb.map(mapper)
        }
    }
}