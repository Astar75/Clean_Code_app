package com.example.myapplication.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.Abstract
import com.example.myapplication.data.Book
import com.example.myapplication.domain.BooksDomainToUiMapper
import com.example.myapplication.domain.BooksInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val booksInteractor: BooksInteractor,
    private val mapper: BooksDomainToUiMapper ,
    private val communication: BooksCommunication
) : ViewModel() { // todo interface
    fun fetchBooks() = viewModelScope.launch(Dispatchers.IO) {
        val result: BooksUi = booksInteractor.fetchBooks().map(mapper)
        Dispatchers.Main.run {
             result.map(Abstract.Mapper.Empty())
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<Book>>) {
        communication.observeSuccess(owner, observer)
    }
}