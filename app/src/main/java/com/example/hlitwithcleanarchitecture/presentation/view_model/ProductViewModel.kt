package com.example.hlitwithcleanarchitecture.presentation.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hlitwithcleanarchitecture.data.repository.ProductRepositoryImp
import com.example.hlitwithcleanarchitecture.domain.entity.ProductModel
import com.example.hlitwithcleanarchitecture.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
): ViewModel() {
    private val _productsFlow: MutableStateFlow<ProductModel> = MutableStateFlow(value = ProductModel.getEmptyProduct())
    val productFlow: StateFlow<ProductModel>
        get() = _productsFlow

    init {
        viewModelScope.launch {
            _productsFlow.value = repository.getProductById(1)
        }
    }
}