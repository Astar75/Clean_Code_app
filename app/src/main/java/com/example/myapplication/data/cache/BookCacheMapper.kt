package com.example.myapplication.data.cache

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book

interface BookCacheMapper : Abstract.Mapper {

    fun map(bookDb: BookDb): Book

    class Base : BookCacheMapper {
        override fun map(bookDb: BookDb): Book = Book(bookDb.id, bookDb.name)
    }
}