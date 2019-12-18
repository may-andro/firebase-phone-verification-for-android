package com.mayandro.firebasephoneauth.ui.auth

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.mayandro.firebasephoneauth.ui.base.BaseViewModel
import com.mayandro.firebasephoneauth.utils.FireBaseAuthProvider
import com.mayandro.firebasephoneauth.utils.PhoneCallbacksListener
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class AuthActivityViewModel @Inject constructor(val fireBaseAuthProvider: FireBaseAuthProvider) :
    BaseViewModel<AuthActivityViewInteractor>(), PhoneCallbacksListener {

    companion object {
        val PHONE_VERIFICATION_PAGE = 0
        val OTP_VERIFICATION_PAGE = 1
        private const val RESEND_WAIT_MILLIS: Long = 30000
        private const val TICK_INTERVAL_MILLIS: Long = 1000

    }

    init {
        fireBaseAuthProvider.setPhoneCallbacksListener(this)
        if (fireBaseAuthProvider.isUserVerified()) {
            viewInteractor?.goToGoalActivity()
        }
    }

    var selectedPhoneNumber = MutableLiveData<String>()
    var selectedOtpNumber = MutableLiveData<String>()

    var pagerPagePosition = MutableLiveData<Int>()

    private var millisUntilFinished = RESEND_WAIT_MILLIS
    private val resendCodeLooper: Handler = Handler()
    private val resendCodeCountdown = Runnable { processCountdownTick() }
    var showResendCodeText = MutableLiveData<Boolean>()

    var phone:String = ""

    fun sendOtpToPhone(phone: String) {
        this.phone = phone
        viewInteractor?.startSMSListener()
        fireBaseAuthProvider.sendVerificationCode(phone)
    }

    fun verifyOtp(otp: String) {
        viewInteractor?.signInWithPhoneAuthCredential(fireBaseAuthProvider.verifyVerificationCode(otp))
    }

    fun resendOtp() {
        viewInteractor?.startSMSListener()
        fireBaseAuthProvider.resendCode(phone)
        resetCountdownTick()
    }

    fun checkIfPhoneIsValid(phone: String): Boolean {
        return phone.let {
            !it.isBlank() && (it.length > 10)
        }
    }

    fun checkIfOtpIsValid(otp: String): Boolean {
        return otp.let {
            !it.isBlank() && (it.length == 6)
        }
    }

    fun processCountdownTick() {
        millisUntilFinished -= TICK_INTERVAL_MILLIS
        when {
            millisUntilFinished <= 0 -> {
                showResendCodeText.value = true
            }
            else -> {
                showResendCodeText.value = false
                resendCodeLooper.postDelayed(resendCodeCountdown, TICK_INTERVAL_MILLIS)
            }
        }
    }

    private fun resetCountdownTick() {
        showResendCodeText.value = false
        millisUntilFinished = RESEND_WAIT_MILLIS
        resendCodeLooper.postDelayed(resendCodeCountdown, TICK_INTERVAL_MILLIS)
    }

    fun clearCountdownTick() {
        resendCodeLooper.removeCallbacks(resendCodeCountdown)
    }

    override fun onVerificationCompleted() {
        viewInteractor?.showSnackBarMessage("Verification Completed")
        viewInteractor?.goToGoalActivity()
    }

    override fun onVerificationCodeDetected(code: String) {
        Timber.d("AuthActivityViewModel onReceive: success $code")
        selectedOtpNumber.value = code
    }

    override fun onVerificationFailed(message: String) {
        Timber.d(message)
        viewInteractor?.showSnackBarMessage(message)
    }

    override fun onCodeSent(
        verificationId: String?,
        token: PhoneAuthProvider.ForceResendingToken?
    ) {
        viewInteractor?.showSnackBarMessage("OTP has sent")
        pagerPagePosition.value = OTP_VERIFICATION_PAGE
    }
}