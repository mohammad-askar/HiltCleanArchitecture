package com.example.hlitwithcleanarchitecture.domain.repository

import com.example.hlitwithcleanarchitecture.domain.entity.ProductModel

interface ProductRepository {

    suspend fun getProductById(id: Int): ProductModel
}