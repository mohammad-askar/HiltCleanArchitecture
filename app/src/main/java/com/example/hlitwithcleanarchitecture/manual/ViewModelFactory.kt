package com.example.hlitwithcleanarchitecture.manual

interface ViewModelFactory<T> {
    fun create(): T
}