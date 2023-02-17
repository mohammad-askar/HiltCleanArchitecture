package com.example.hlitwithcleanarchitecture.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductModel(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val price: Double
)