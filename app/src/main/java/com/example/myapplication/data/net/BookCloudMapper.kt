package com.example.myapplication.data.net

import com.example.myapplication.core.Abstract
import com.example.myapplication.core.Book

interface BookCloudMapper : Abstract.Mapper {
    fun map(id: Int, name: String): Book

    class Base : BookCloudMapper {
        override fun map(id: Int, name: String): Book = Book(id, name)
    }
}
