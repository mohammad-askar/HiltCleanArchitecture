package com.example.hlitwithcleanarchitecture.data.repository

import com.example.hlitwithcleanarchitecture.di.PaymentFirstImp
import com.example.hlitwithcleanarchitecture.domain.repository.PaymentRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class PaymentRepositoryFirstImp @Inject constructor() : PaymentRepository {

    override suspend fun confirm(): String {
        delay(500L)
        return "First Implementation"
    }
}