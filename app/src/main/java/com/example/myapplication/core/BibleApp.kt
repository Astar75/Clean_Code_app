package com.example.myapplication.core

import android.app.Application
import com.example.myapplication.data.BooksCloudDataSource
import com.example.myapplication.data.BooksCloudMapper
import com.example.myapplication.data.BooksRepository
import com.example.myapplication.data.cache.BookCacheMapper
import com.example.myapplication.data.cache.BooksCacheDataSource
import com.example.myapplication.data.cache.BooksCacheMapper
import com.example.myapplication.data.cache.RealmProvider
import com.example.myapplication.data.net.BookCloudMapper
import com.example.myapplication.data.net.BooksService
import retrofit2.Retrofit

class BibleApp : Application() {

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        val service = retrofit.create(BooksService::class.java)

        val cloudDataSource = BooksCloudDataSource.Base(service)
        val cacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())
        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())
        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())
        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
    }
}