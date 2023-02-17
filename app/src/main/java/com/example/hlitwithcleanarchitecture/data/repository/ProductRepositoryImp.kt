package com.example.hlitwithcleanarchitecture.data.repository

import com.example.hlitwithcleanarchitecture.data.local.ProductDataBase
import com.example.hlitwithcleanarchitecture.data.remote.ProductApi
import com.example.hlitwithcleanarchitecture.domain.entity.ProductModel
import com.example.hlitwithcleanarchitecture.domain.repository.ProductRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(
    //private val dataBase: ProductDataBase,
    private val api: ProductApi
): ProductRepository {

    override suspend fun getProductById(id: Int): ProductModel {
        delay(500)
        return ProductModel(uid = 1, price = 500.99)
    }
}