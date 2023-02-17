package com.example.hlitwithcleanarchitecture.di

import android.content.Context
import androidx.room.Room
import com.example.hlitwithcleanarchitecture.constant.Constants.BASE_URL
import com.example.hlitwithcleanarchitecture.constant.Constants.DATABASE_NAME
import com.example.hlitwithcleanarchitecture.data.local.ProductDataBase
import com.example.hlitwithcleanarchitecture.data.remote.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesProductApi(): ProductApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun providesProductDatabase(context: Context): ProductDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = ProductDataBase::class.java,
            name = DATABASE_NAME
        ).build()
    }
}