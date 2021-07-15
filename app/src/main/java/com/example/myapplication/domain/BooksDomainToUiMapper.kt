package com.example.myapplication.domain

import com.example.myapplication.core.Abstract
import com.example.myapplication.data.Book
import com.example.myapplication.presentation.BooksUi

interface BooksDomainToUiMapper: Abstract.Mapper {

    fun map(books: List<Book>): BooksUi
    fun map(errorType: ErrorType): BooksUi
}