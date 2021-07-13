package com.example.myapplication.data.cache

import io.realm.Realm

interface RealmProvider {

    fun provide(): Realm

    class Base() : RealmProvider {
        override fun provide(): Realm {
            return Realm.getDefaultInstance()
        }
    }
}