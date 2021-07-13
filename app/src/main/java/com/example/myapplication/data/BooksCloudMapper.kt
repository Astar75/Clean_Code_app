package com.example.myapplication.data

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book
import com.example.myapplication.data.net.BookCloud
import com.example.myapplication.data.net.BookCloudMapper

interface BooksCloudMapper : Abstract.Mapper {
    fun map(cloudList: List<BookCloud>): List<Book>

    class Base(private val bookMapper: BookCloudMapper) : BooksCloudMapper {
        override fun map(cloudList: List<BookCloud>): List<Book> =
            cloudList.map { bookCloud: BookCloud ->
                bookCloud.map(bookMapper)
            }
    }
}