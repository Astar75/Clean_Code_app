package com.example.myapplication.domain

import com.example.myapplication.data.Book
import com.example.myapplication.data.BooksDataToDomainMapper

class BaseBooksDataToDomainMapper: BooksDataToDomainMapper {

    override fun map(books: List<Book>): BookDomain = BookDomain.Success(books)

    override fun map(e: Exception): BookDomain = BookDomain.Fail(e)
}