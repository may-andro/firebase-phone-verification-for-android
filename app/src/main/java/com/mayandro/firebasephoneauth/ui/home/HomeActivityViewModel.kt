package com.mayandro.firebasephoneauth.ui.home

import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(): ViewModel() {
    //@Inject lateinit var onlineCheckerImpl: ConnectionProviderManager

    override fun onCleared() {
        super.onCleared()
        Timber.d("unsubscribeFromDataStore()")
    }
}