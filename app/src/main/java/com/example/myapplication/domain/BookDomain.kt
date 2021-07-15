package com.example.myapplication.domain

import com.example.myapplication.core.Abstract
import com.example.myapplication.data.Book
import com.example.myapplication.presentation.BooksUi
import retrofit2.HttpException
import java.net.UnknownHostException


// TODO: 15.07.2021 rename to BooksDomain

sealed class BookDomain : Abstract.Object<BooksUi, BooksDomainToUiMapper>() {

    class Success(private val books: List<Book>) : BookDomain() {
        override fun map(mapper: BooksDomainToUiMapper): BooksUi = mapper.map(books)
    }

    class Fail(private val e: Exception) : BookDomain() {
        override fun map(mapper: BooksDomainToUiMapper): BooksUi = mapper.map(
            when (e) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                else -> ErrorType.GENERIC_ERROR
            }
        )
    }
}