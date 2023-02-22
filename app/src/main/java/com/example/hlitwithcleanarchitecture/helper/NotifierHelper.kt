package com.example.hlitwithcleanarchitecture.helper

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@EntryPoint
@InstallIn(SingletonComponent::class)
interface NotifierEntryPoint{
    val firebaseNotifier: FirebaseNotifier
}
class NotifierHelper @Inject constructor(
    @ApplicationContext private val context: Context
) {
    var firebaseNotifier: FirebaseNotifier

    init {
        val notificationFactory = EntryPointAccessors.fromApplication(
            context = context,
            entryPoint = NotifierEntryPoint::class.java
        )

        firebaseNotifier = notificationFactory.firebaseNotifier
    }
}