package com.example.hlitwithcleanarchitecture.manual

import com.example.hlitwithcleanarchitecture.domain.repository.ProductRepository
import com.example.hlitwithcleanarchitecture.presentation.view_model.ProductViewModel

class ProductViewModelFactory(
    private val repository: ProductRepository
): ViewModelFactory<ProductViewModel> {
    override fun create(): ProductViewModel {
        return ProductViewModel(repository = repository)
    }
}