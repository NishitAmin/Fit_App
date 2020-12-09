package project.st991497190.vishvakumar.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
//import org.rohan.patel.finalprojectandroid.R
import project.st991497190.vishvakumar.R
//import org.rohan.patel.finalprojectandroid.databinding.AppScreenBinding
import project.st991497190.vishvakumar.databinding.AppScreenBinding

class AppFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<AppScreenBinding>(inflater,
                R.layout.app_screen,container,false)

        binding.buttonCalculateBMI.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_appFragment_to_bmiFragment)
        }

        binding.buttonViewAnalytics.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_appFragment_to_analyticsFragment)
        }

        binding.buttonAddLog.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_appFragment_to_addLogFragment)
        }

        binding.buttonViewLogs.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_appFragment_to_viewLogsFragment)
        }
        return binding.root
    }
}