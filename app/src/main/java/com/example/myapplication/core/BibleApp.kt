package com.example.myapplication.core

import android.app.Application
import com.example.myapplication.domain.BooksInteractor
import com.example.myapplication.presentation.BaseBooksDomainToUiMapper
import com.example.myapplication.presentation.BooksCommunication
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.ResourceProvider

class BibleApp : Application() {

    lateinit var mainViewModel : MainViewModel

    override fun onCreate() {
        super.onCreate()

        val booksInteractor: BooksInteractor = TODO()
        mainViewModel = MainViewModel(
            booksInteractor,
            BaseBooksDomainToUiMapper(BooksCommunication.Base(), ResourceProvider.Base(this))
        )
    }
}