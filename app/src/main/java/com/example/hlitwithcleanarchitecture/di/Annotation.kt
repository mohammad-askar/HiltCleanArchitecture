package com.example.hlitwithcleanarchitecture.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PaymentFirstImp()

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PaymentSecondImp()


