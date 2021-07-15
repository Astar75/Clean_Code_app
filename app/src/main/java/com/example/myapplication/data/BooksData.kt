package com.example.myapplication.data

import com.example.myapplication.core.Abstract
import com.example.myapplication.domain.BookDomain

sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>()