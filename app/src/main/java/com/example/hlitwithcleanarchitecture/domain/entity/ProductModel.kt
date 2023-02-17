package com.example.hlitwithcleanarchitecture.domain.entity

import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hlitwithcleanarchitecture.presentation.view_model.ProductViewModel

@Entity
data class ProductModel(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val price: Double
){
    companion object{
        fun getEmptyProduct(): ProductModel {
            return ProductModel(uid = 0, price = 0.00)
        }
    }

    override fun toString(): String {
        return "the Id is: $uid and Price $price"
    }
}