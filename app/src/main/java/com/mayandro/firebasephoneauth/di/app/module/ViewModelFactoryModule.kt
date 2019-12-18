package com.mayandro.firebasephoneauth.di.app.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayandro.firebasephoneauth.di.app.scope.AppScoped
import com.mayandro.firebasephoneauth.di.app.utils.ViewModelFactory
import com.mayandro.firebasephoneauth.di.app.utils.ViewModelKey
import com.mayandro.firebasephoneauth.ui.auth.AuthActivityViewModel
import com.mayandro.firebasephoneauth.ui.home.HomeActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

    @Binds
    @AppScoped
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AuthActivityViewModel::class)
    abstract fun bindAuthActivityViewModel(authActivityViewModel: AuthActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    abstract fun bindGoalActivityViewModel(goalActivityViewModel: HomeActivityViewModel): ViewModel
}
