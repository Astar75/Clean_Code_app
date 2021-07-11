package com.example.myapplication.data

import com.example.myapplication.core.Abstract
import com.example.myapplication.domain.BookDomain

sealed class BookData : Abstract.Object<BookDomain, Abstract.Mapper.Empty>() {
}