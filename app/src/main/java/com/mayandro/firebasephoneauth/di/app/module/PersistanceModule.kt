package com.mayandro.firebasephoneauth.di.app.module

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.mayandro.firebasephoneauth.di.app.scope.AppScoped
import dagger.Module
import dagger.Provides

@Module
class PersistanceModule {

    @Provides
    @AppScoped
    internal fun provideSharedPreference(context: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}