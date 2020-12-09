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
//import org.rohan.patel.finalprojectandroid.databinding.AnalyticsScreenBinding
import project.st991497190.vishvakumar.databinding.AnalyticsScreenBinding

class AnalyticsFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<AnalyticsScreenBinding>(inflater,
                R.layout.analytics_screen,container,false)



        return binding.root
    }
}