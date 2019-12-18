package com.mayandro.firebasephoneauth.ui.auth

import com.google.firebase.auth.PhoneAuthCredential
import com.mayandro.firebasephoneauth.ui.base.ViewInteractor

interface AuthActivityViewInteractor: ViewInteractor {

    fun showSnackBarMessage(message: String)

    fun goToGoalActivity()

    fun startSMSListener()

    fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential)
}