package com.example.myapplication.data.cache

import com.example.myapplication.core.Book
import io.realm.Realm

interface BooksCacheDataSource {

    fun fetchBooks(): List<BookDb>

    fun saveBooks(books: List<Book>)

    class Base(private val realmProvider: RealmProvider) : BooksCacheDataSource {
        override fun fetchBooks(): List<BookDb> {
            realmProvider.provide().use { realm: Realm ->
                val booksDb = realm.where(BookDb::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(booksDb)
            }
        }

        override fun saveBooks(books: List<Book>) =
            realmProvider.provide().use { realm: Realm ->
                realm.executeTransaction {
                    books.forEach { book ->
                        val bookDb = it.createObject(BookDb::class.java, book.id)
                        bookDb.name = book.name
                    }
                }
            }


    }
}