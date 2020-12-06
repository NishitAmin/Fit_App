package org.rohan.patel.finalprojectandroid.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.rohan.patel.finalprojectandroid.R
import org.rohan.patel.finalprojectandroid.databinding.LoginScreenBinding

class LoginFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<LoginScreenBinding>(inflater,
                R.layout.login_screen,container,false)

        binding.buttonLogin.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_loginFragment_to_appFragment)
        }

        return binding.root
    }
}