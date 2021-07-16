package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.core.BibleApp
import com.example.myapplication.presentation.BibleAdapter

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as BibleApp).mainViewModel

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = BibleAdapter()
        recyclerView.adapter = adapter

        viewModel.observe(this, {
            adapter.update(it)
        })
        viewModel.fetchBooks()

        // TODO: 17.07.2021  observe fail
    }

}