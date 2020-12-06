package org.rohan.patel.finalprojectandroid.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.rohan.patel.finalprojectandroid.R
import org.rohan.patel.finalprojectandroid.databinding.HomeScreenBinding

class HomeFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<HomeScreenBinding>(inflater,
                R.layout.home_screen,container,false)

        binding.buttonGetStarted.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homeScreenFragment_to_signUpFragment)
        }

        binding.buttonGoToLogin.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homeScreenFragment_to_loginFragment)
        }

        return binding.root
    }
}