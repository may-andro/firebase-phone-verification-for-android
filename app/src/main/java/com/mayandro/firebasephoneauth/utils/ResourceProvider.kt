package com.mayandro.firebasephoneauth.utils

import android.content.Context
import androidx.annotation.StringRes

interface BaseResourceProvider {
    fun getString(@StringRes id: Int): String
    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String
}

class ResourceProvider(private val context: Context) : BaseResourceProvider {

    override fun getString(@StringRes id: Int): String {
        return context.getString(id)
    }

    override fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
        return context.getString(resId, formatArgs)
    }
}