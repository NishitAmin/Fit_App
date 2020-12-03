package org.rohan.patel.finalprojectandroid.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.log_exercise.*
import kotlinx.android.synthetic.main.log_exercise.view.*
import org.rohan.patel.finalprojectandroid.R
import org.rohan.patel.finalprojectandroid.ViewModels.WeightLiftingViewModel

class AddLogFragment : Fragment() {
    var sval : String = ""
    private val weightLiftingViewModel by lazy {
        ViewModelProvider(this).get(WeightLiftingViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val mainView = inflater.inflate(R.layout.log_exercise, container, false)
        mainView.button2.setOnClickListener {
            view->
            mainView.textView3.text = weightLiftingViewModel.reps.toString()
        }
        val exerciseList = resources.getStringArray(R.array.exercisesList)
        val adapter = ArrayAdapter(container!!.context,android.R.layout.simple_list_item_1,exerciseList)
        mainView.spinner.adapter = adapter

        mainView.spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val trans = fragmentManager!!.beginTransaction()
                trans.replace(R.id.fragmentExercises,RunningFragment())
               // trans.addToBackStack(null)
                trans.commit()

            }

        }

        return mainView
    }

    fun changeView(s:String){
        sval = s
    }

}