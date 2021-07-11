package com.example.myapplication.domain

import com.example.myapplication.core.Abstract
import com.example.myapplication.presentation.BookUi

sealed class BookDomain: Abstract.Object<BookUi, Abstract.Mapper.Empty>() {
}