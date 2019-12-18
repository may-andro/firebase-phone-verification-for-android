package com.mayandro.firebasephoneauth.ui.auth.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.mayandro.firebasephoneauth.R
import com.mayandro.firebasephoneauth.databinding.FragmentPhoneVerificationBinding
import com.mayandro.firebasephoneauth.ui.auth.AuthActivityViewModel
import com.mayandro.firebasephoneauth.ui.base.BaseFragment


class PhoneVerificationFragment : BaseFragment<FragmentPhoneVerificationBinding, AuthActivityViewModel>() {

    companion object {
        fun newInstance(): PhoneVerificationFragment {
            val args = Bundle()
            val fragment = PhoneVerificationFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getViewModelClass(): Class<AuthActivityViewModel> = AuthActivityViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_phone_verification

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedPhoneNumber.observe(
            requireActivity(),
            Observer<String?> { value ->
                binding.textInputEditTextPhone.setText(value ?: "")
            })

        binding.buttonVerifyPhone.setOnClickListener {
            activity?.hideKeyboard()
            if (viewModel.checkIfPhoneIsValid(binding.textInputEditTextPhone.text.toString())) {
                viewModel.sendOtpToPhone(binding.textInputEditTextPhone.text.toString())
            } else {
                binding.textInputLayoutPhone.error = "Invalid Phone: Please enter phone number with country code"
            }
        }
    }
}