package com.example.hlitwithcleanarchitecture.helper

import kotlinx.coroutines.delay
import javax.inject.Inject

class FirebaseNotifier @Inject constructor() {

    suspend fun getNotification(): String{
        delay(3000L)
        return "you have just received a Notification "
    }
}