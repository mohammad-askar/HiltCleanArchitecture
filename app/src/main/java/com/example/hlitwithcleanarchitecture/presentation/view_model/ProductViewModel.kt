package com.example.hlitwithcleanarchitecture.presentation.view_model

import androidx.compose.runtime.mutableStateOf
import com.example.hlitwithcleanarchitecture.data.repository.ProductRepositoryImp
import com.example.hlitwithcleanarchitecture.domain.entity.ProductModel
import com.example.hlitwithcleanarchitecture.domain.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductViewModel(
    private val repository: ProductRepository
) {
    private val _productsFlow: MutableStateFlow<List<ProductModel>> = MutableStateFlow(value = emptyList())
    val productFlow: StateFlow<List<ProductModel>> = _productsFlow

    init {
        _productsFlow.value = listOf(
            ProductModel(1, 1500.00),
            ProductModel(2, 4400.00),
            ProductModel(3, 640.00),
            ProductModel(4, 500.00),
            ProductModel(5, 3990.00),
            ProductModel(6, 500.00),
            ProductModel(7, 640.00),
            ProductModel(8, 5980.00),
            ProductModel(9, 150.00),
            ProductModel(10, 99.00),
        )
    }
}