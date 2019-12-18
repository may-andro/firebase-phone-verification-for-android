package com.mayandro.firebasephoneauth.di.app.module

import com.google.firebase.auth.FirebaseAuth
import com.mayandro.firebasephoneauth.di.app.scope.AppScoped
import dagger.Module
import dagger.Provides


@Module
class AppModule {

    @Provides
    @AppScoped
    internal fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}