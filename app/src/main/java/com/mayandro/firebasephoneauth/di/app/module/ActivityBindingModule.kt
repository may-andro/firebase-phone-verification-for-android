package com.mayandro.firebasephoneauth.di.app.module

import com.mayandro.firebasephoneauth.di.app.scope.ActivityScoped
import com.mayandro.firebasephoneauth.di.auth.AuthActivityModule
import com.mayandro.firebasephoneauth.di.auth.FragmentBindingModule
import com.mayandro.firebasephoneauth.di.home.HomeActivityModule
import com.mayandro.firebasephoneauth.ui.auth.AuthActivity
import com.mayandro.firebasephoneauth.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [AuthActivityModule::class, FragmentBindingModule::class])
    internal abstract fun bindAuthActivity(): AuthActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    internal abstract fun bindGoalsActivity(): HomeActivity
}