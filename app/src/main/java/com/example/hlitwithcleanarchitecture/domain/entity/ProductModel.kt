package com.example.hlitwithcleanarchitecture.domain.entity

import androidx.room.Entity

@Entity
data class ProductModel(
    private val uid: Int,
    private val price: Double
)