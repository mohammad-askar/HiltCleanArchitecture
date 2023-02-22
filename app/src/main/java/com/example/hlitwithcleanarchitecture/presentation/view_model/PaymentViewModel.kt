package com.example.hlitwithcleanarchitecture.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hlitwithcleanarchitecture.di.PaymentFirstImp
import com.example.hlitwithcleanarchitecture.di.PaymentSecondImp
import com.example.hlitwithcleanarchitecture.domain.repository.PaymentRepository
import com.example.hlitwithcleanarchitecture.helper.NotifierHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    @PaymentFirstImp private val paymentFirstMethod: PaymentRepository,
    @PaymentSecondImp private val paymentSecondMethod: PaymentRepository,
    private val notifierHelper: NotifierHelper
): ViewModel() {

    private val _paymentFirstFlow: MutableStateFlow<String> = MutableStateFlow("")
    val paymentFirstFlow: StateFlow<String>
    get() = _paymentFirstFlow

    private val _paymentSecondFlow: MutableStateFlow<String> = MutableStateFlow("")
    val paymentSecondFlow: StateFlow<String>
        get() = _paymentSecondFlow

    private val _notifierFlow: MutableStateFlow<String> = MutableStateFlow("")
    val notifierFlow: StateFlow<String>
    get() = _notifierFlow

    init {
        viewModelScope.launch {
            val firstJob = async { paymentFirstMethod.confirm() }
            val secondJob = async { paymentSecondMethod.confirm() }
            val notifierJob = async { notifierHelper.firebaseNotifier.getNotification() }
            _paymentFirstFlow.value = firstJob.await()
            _paymentSecondFlow.value = secondJob.await()
            _notifierFlow.value = notifierJob.await()
        }
    }



}