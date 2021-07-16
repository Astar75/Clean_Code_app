package com.example.myapplication.presentation

import com.example.myapplication.data.Book
import com.example.myapplication.domain.BooksDomainToUiMapper
import com.example.myapplication.domain.ErrorType

class BaseBooksDomainToUiMapper(
    private val communication: BooksCommunication,
    private val resourceProvider: ResourceProvider
) : BooksDomainToUiMapper {

    override fun map(books: List<Book>): BooksUi =
        BooksUi.Success(communication, books)

    override fun map(errorType: ErrorType): BooksUi =
        BooksUi.Fail(communication, errorType, resourceProvider)
}