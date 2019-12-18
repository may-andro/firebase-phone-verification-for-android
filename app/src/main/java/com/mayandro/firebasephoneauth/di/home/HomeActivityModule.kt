package com.mayandro.firebasephoneauth.di.home

import android.app.Application
import android.content.Context
import com.mayandro.firebasephoneauth.di.app.scope.ActivityScoped
import com.mayandro.firebasephoneauth.ui.home.HomeActivity
import com.mayandro.firebasephoneauth.utils.BaseResourceProvider
import com.mayandro.firebasephoneauth.utils.ResourceProvider
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerAppCompatActivity


@Module
class HomeActivityModule {

    @Provides
    @ActivityScoped
    fun provideActivityContext(activity: HomeActivity): Context {
        return activity
    }

    @Provides
    @ActivityScoped
    fun provideActivity(homeActivity: HomeActivity): DaggerAppCompatActivity {
        return homeActivity
    }

    @Provides
    @ActivityScoped
    fun provideResourceProvider(context: Application): BaseResourceProvider {
        return ResourceProvider(context)
    }
}