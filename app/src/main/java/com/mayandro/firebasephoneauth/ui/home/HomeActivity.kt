package com.mayandro.firebasephoneauth.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.mayandro.firebasephoneauth.R
import com.mayandro.firebasephoneauth.databinding.ActivityHomeBinding
import com.mayandro.firebasephoneauth.ui.auth.AuthActivity
import com.mayandro.firebasephoneauth.ui.base.BaseActivity

class HomeActivity: BaseActivity<ActivityHomeBinding, HomeActivityViewModel>() {


    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
    override fun getViewModelClass(): Class<HomeActivityViewModel> = HomeActivityViewModel::class.java

    override fun layoutId(): Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.button.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(AuthActivity.getIntent(this))
            finish()
        }
    }
}