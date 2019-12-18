package com.mayandro.firebasephoneauth.di.app.component

import android.app.Application
import com.mayandro.firebasephoneauth.BaseApplication
import com.mayandro.firebasephoneauth.di.app.module.*
import com.mayandro.firebasephoneauth.di.app.scope.AppScoped
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScoped
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    AppModule::class,
    ViewModelFactoryModule::class,
    NetworkModule::class,
    PersistanceModule::class
])
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}