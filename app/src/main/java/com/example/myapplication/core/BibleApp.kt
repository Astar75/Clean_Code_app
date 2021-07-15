package com.example.myapplication.core

import android.app.Application
import com.example.myapplication.data.BooksRepository
import com.example.myapplication.domain.BaseBooksDataToDomainMapper
import com.example.myapplication.domain.BooksInteractor

class BibleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val booksRepository : BooksRepository = TODO("merge")
        val booksInteractor = BooksInteractor.Base(booksRepository, BaseBooksDataToDomainMapper())
    }
}