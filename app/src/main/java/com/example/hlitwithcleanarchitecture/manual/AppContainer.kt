package com.example.hlitwithcleanarchitecture.manual

import android.content.Context
import androidx.room.Room
import com.example.hlitwithcleanarchitecture.constant.Constants.BASE_URL
import com.example.hlitwithcleanarchitecture.constant.Constants.DATABASE_NAME
import com.example.hlitwithcleanarchitecture.data.local.ProductDataBase
import com.example.hlitwithcleanarchitecture.data.remote.ProductApi
import com.example.hlitwithcleanarchitecture.data.repository.ProductRepositoryImp
import retrofit2.Retrofit

class AppContainer(
    context: Context
) {

    private val db = Room.databaseBuilder(
        context = context,
        klass = ProductDataBase::class.java,
        name = DATABASE_NAME
    ).build()

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()
        .create(ProductApi::class.java)

    private val repository = ProductRepositoryImp(
        //dataBase = db,
        api = api
    )

    val productViewModelFactory = ProductViewModelFactory(
        repository = repository
    )

}