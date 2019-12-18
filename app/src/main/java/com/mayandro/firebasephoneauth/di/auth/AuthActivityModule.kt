package com.mayandro.firebasephoneauth.di.auth

import com.mayandro.firebasephoneauth.di.app.scope.ActivityScoped
import com.mayandro.firebasephoneauth.ui.auth.AuthActivity
import com.mayandro.firebasephoneauth.ui.auth.adapter.AuthPagerAdapter
import com.mayandro.firebasephoneauth.utils.BaseResourceProvider
import com.mayandro.firebasephoneauth.utils.ResourceProvider
import dagger.Module
import dagger.Provides


@Module
class AuthActivityModule {
    @Provides
    @ActivityScoped
    fun provideResourceProvider(context: AuthActivity): BaseResourceProvider {
        return ResourceProvider(context)
    }

    @Provides
    @ActivityScoped
    fun provideAuthPagerAdapter(activity: AuthActivity): AuthPagerAdapter {
        return AuthPagerAdapter(activity)
    }
}