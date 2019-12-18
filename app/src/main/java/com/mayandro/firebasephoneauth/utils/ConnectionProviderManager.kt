package com.mayandro.firebasephoneauth.utils

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.mayandro.firebasephoneauth.di.app.scope.AppScoped
import javax.inject.Inject

interface OnlineChecker {
    fun isOnline(): Boolean
}

@AppScoped
class ConnectionProviderManager @Inject constructor(private val connectivityManager: ConnectivityManager) :
    OnlineChecker {

    override fun isOnline(): Boolean {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            return networkInfo.isConnected
        }
    }
}

