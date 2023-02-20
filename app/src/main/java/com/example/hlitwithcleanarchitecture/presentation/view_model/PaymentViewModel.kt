package com.example.hlitwithcleanarchitecture.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hlitwithcleanarchitecture.di.PaymentFirstImp
import com.example.hlitwithcleanarchitecture.di.PaymentSecondImp
import com.example.hlitwithcleanarchitecture.domain.repository.PaymentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    @PaymentFirstImp private val paymentFirstMethod: PaymentRepository,
    @PaymentSecondImp private val paymentSecondMethod: PaymentRepository
): ViewModel() {

    private val _paymentFirstFlow: MutableStateFlow<String> = MutableStateFlow("")
    val paymentFirstFlow: StateFlow<String>
    get() = _paymentFirstFlow

    private val _paymentSecondFlow: MutableStateFlow<String> = MutableStateFlow("")
    val paymentSecondFlow: StateFlow<String>
        get() = _paymentSecondFlow

    init {
        viewModelScope.launch {
            val firstJob = async { paymentFirstMethod.confirm() }
            val secondJob = async { paymentSecondMethod.confirm() }

            _paymentFirstFlow.value = firstJob.await()
            _paymentSecondFlow.value = secondJob.await()
        }
    }



}