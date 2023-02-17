package com.example.hlitwithcleanarchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hlitwithcleanarchitecture.domain.entity.ProductModel

@Database(entities = [ProductModel::class], version = 1)
abstract class ProductDataBase: RoomDatabase() {
}