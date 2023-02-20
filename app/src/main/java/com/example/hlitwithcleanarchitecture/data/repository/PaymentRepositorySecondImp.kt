package com.example.hlitwithcleanarchitecture.data.repository

import com.example.hlitwithcleanarchitecture.domain.repository.PaymentRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class PaymentRepositorySecondImp @Inject constructor() : PaymentRepository {

    override suspend fun confirm(): String {
        delay(2000L)
        return "Second Implementation"
    }
}