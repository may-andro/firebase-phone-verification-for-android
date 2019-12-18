package com.mayandro.firebasephoneauth.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val PREFS_KEY_USER_VISITED_ONBOARDING = "user_visited_onboarding"
    }

    var userVisistedOnBoarding: Boolean
        get(): Boolean {
            return sharedPreferences.getBoolean(PREFS_KEY_USER_VISITED_ONBOARDING, false)
        }
        set(value) {
            sharedPreferences.edit().putBoolean(PREFS_KEY_USER_VISITED_ONBOARDING, value).apply()
        }
}