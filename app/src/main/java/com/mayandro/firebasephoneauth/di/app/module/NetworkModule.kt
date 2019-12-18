package com.mayandro.firebasephoneauth.di.app.module

import android.app.Application
import android.content.Context
import dagger.Module
import android.net.ConnectivityManager
import com.mayandro.firebasephoneauth.di.app.scope.AppScoped
import dagger.Provides



@Module
class NetworkModule {

    @Provides
    @AppScoped
    internal fun provideConnectivityManager(context: Application): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}