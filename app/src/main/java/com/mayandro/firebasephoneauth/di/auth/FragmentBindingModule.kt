package com.mayandro.firebasephoneauth.di.auth

import com.mayandro.firebasephoneauth.di.app.scope.FragmentScoped
import com.mayandro.firebasephoneauth.ui.auth.fragments.OtpVerificationFragment
import com.mayandro.firebasephoneauth.ui.auth.fragments.PhoneVerificationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun bindOtpVerificationFragment(): OtpVerificationFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun bindPhoneVerificationFragment(): PhoneVerificationFragment

}