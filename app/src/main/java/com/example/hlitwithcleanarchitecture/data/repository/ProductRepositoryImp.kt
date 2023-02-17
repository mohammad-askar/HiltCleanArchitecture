package com.example.hlitwithcleanarchitecture.data.repository

import com.example.hlitwithcleanarchitecture.data.local.ProductDataBase
import com.example.hlitwithcleanarchitecture.data.remote.ProductApi
import com.example.hlitwithcleanarchitecture.domain.repository.ProductRepository

class ProductRepositoryImp(
    private val dataBase: ProductDataBase,
    private val api: ProductApi
): ProductRepository {

    // Your implementation
    // ToDo()
}