package com.mayandro.firebasephoneauth.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel<VI: ViewInteractor>: ViewModel() {

    private val mCompositeDisposable: CompositeDisposable? = null

    var viewInteractor: VI? = null
        set

    override fun onCleared() {
        mCompositeDisposable?.dispose()
        super.onCleared()
    }
}