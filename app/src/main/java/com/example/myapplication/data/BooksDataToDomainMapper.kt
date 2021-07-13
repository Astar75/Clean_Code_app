package com.example.myapplication.data

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book
import com.example.myapplication.data.net.BookCloud
import com.example.myapplication.domain.BookDomain
import retrofit2.HttpException
import java.net.UnknownHostException

interface BooksDataToDomainMapper: Abstract.Mapper {

    fun map(books : List<BookCloud>): BookDomain
    fun map(e: Exception): BookDomain
}
