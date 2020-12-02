package org.rohan.patel.finalprojectandroid.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.bmi_screen.*
import org.rohan.patel.finalprojectandroid.R
import org.rohan.patel.finalprojectandroid.databinding.BmiScreenBinding

class BmiFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var binding = DataBindingUtil.inflate<BmiScreenBinding>(inflater,
                R.layout.bmi_screen,container,false)

//        var bmi = 0
//        var weight = inputWeight.text.toString().toFloat()
//        var height = inputHeight.text.toString().toFloat()
//
//        bmi = (weight/height*height).toInt()
//
//        binding.buttonCalculate.setOnClickListener {
//            textBmi.text = bmi.toString()
//        }


        return binding.root


    }
}