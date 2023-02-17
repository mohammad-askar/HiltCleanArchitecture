package com.example.hlitwithcleanarchitecture.di

import com.example.hlitwithcleanarchitecture.data.repository.ProductRepositoryImp
import com.example.hlitwithcleanarchitecture.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsProductRepository(
        repository: ProductRepositoryImp
    ): ProductRepository
}