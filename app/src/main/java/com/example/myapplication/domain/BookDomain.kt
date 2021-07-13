package com.example.myapplication.domain

import com.example.myapplication.core.Abstract
import com.example.myapplication.presentation.BookUi

sealed class BookDomain: Abstract.Object<BookUi, Abstract.Mapper.Empty>() {
    class Success(): BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO()
        }
    }

    class Fail(errorType: Int): BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }
    }
}