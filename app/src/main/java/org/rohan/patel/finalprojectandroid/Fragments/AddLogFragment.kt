package org.rohan.patel.finalprojectandroid.Fragments

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_log_exercise.*
import org.rohan.patel.finalprojectandroid.R
import org.rohan.patel.finalprojectandroid.databinding.FragmentLogExerciseBinding
import org.rohan.patel.finalprojectandroid.viewModels.AddLogViewModel
import org.rohan.patel.finalprojectandroid.viewModelsFactory.AddLogViewModelFactory
import org.rohan.patel.roomdatabasesample.FitDatabase

class AddLogFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val mainView : FragmentLogExerciseBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_log_exercise, container, false)

        // Adding View Model
        val application = requireNotNull(this.activity).application
        val weightLiftingDao = FitDatabase.getInstance(application).weightLiftingDao()
        val runningDao = FitDatabase.getInstance(application).runningDao()
        val swimmingDao = FitDatabase.getInstance(application).swimmingDao()
        val viewModelFactory = AddLogViewModelFactory(weightLiftingDao,runningDao,swimmingDao,application)
        val addLogViewModel = ViewModelProviders.of(this,viewModelFactory).get(AddLogViewModel::class.java)
        mainView.logViewModel = addLogViewModel

        // Spinner
        val exerciseList = resources.getStringArray(R.array.exercisesList)
        val adapter = ArrayAdapter(container!!.context,android.R.layout.simple_list_item_1,exerciseList)
        mainView.spinner.adapter = adapter

        mainView.spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.d("POSITION", ""+position)
                addLogViewModel.selectedSpinnerIndex = position
                if(position == 0){
                    weightLiftingIsSelected()
                }
                if(position==1){
                    runningIsSelected()
                }
                if(position==2){
                    swimmingIsSelected()
                }
            }

        }

        return mainView.root
    }



   fun weightLiftingIsSelected(){
       makeAllVisible()
       input1.setHint("Reps")
       input2.setHint("Sets")
       input3.setHint("Weight")

   }
    fun runningIsSelected(){
        makeAllVisible()
        input1.setHint("Distance")
        input2.setHint("Speed")
        input3.visibility = View.GONE
    }
    fun swimmingIsSelected(){
        makeAllVisible()
        input1.setHint("Speed")
        input2.setHint("Kicks")
        input3.setHint("Time")
    }
    fun makeAllVisible(){
        input1.visibility = View.VISIBLE
        input2.visibility = View.VISIBLE
        input3.visibility = View.VISIBLE
    }

}