package com.example.hlitwithcleanarchitecture.domain.repository

interface PaymentRepository {

    suspend fun confirm(): String
}