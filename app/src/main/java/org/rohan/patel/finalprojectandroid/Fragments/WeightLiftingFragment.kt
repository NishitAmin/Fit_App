package org.rohan.patel.finalprojectandroid.Fragments

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_weightlifting.view.*
import org.rohan.patel.finalprojectandroid.R
import org.rohan.patel.finalprojectandroid.ViewModels.WeightLiftingViewModel
import org.rohan.patel.finalprojectandroid.databinding.FragmentWeightliftingBinding


class WeightLiftingFragment : Fragment() {
    private val weightLiftingViewModel by lazy {
        ViewModelProvider(this).get(WeightLiftingViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var mainView : FragmentWeightliftingBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_weightlifting, container, false)
        mainView.weightLiftingViewModel = weightLiftingViewModel

        return mainView.root
    }

}
