package org.rohan.patel.finalprojectandroid.viewModels

import android.app.Application
import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.fragment_log_exercise.view.*
import org.rohan.patel.finalprojectandroid.Dao.RunningDao
import org.rohan.patel.finalprojectandroid.Dao.SwimmingDao
import org.rohan.patel.finalprojectandroid.Dao.WeightLiftingDao
import org.rohan.patel.finalprojectandroid.Entity.WeightLiftingEntity
import org.rohan.patel.finalprojectandroid.Fragments.AddLogFragment
import org.rohan.patel.finalprojectandroid.MainActivity
import org.rohan.patel.finalprojectandroid.R
import org.rohan.patel.finalprojectandroid.databinding.FragmentLogExerciseBinding
import org.rohan.patel.roomdatabasesample.FitDatabase
import java.util.*
import kotlin.math.log

class AddLogViewModel(val weightLiftingDao: WeightLiftingDao,val runningDao: RunningDao, val swimmingDao: SwimmingDao,application: Application) : ViewModel() {
    var weightLiftingViewModel = WeightLiftingViewModel(weightLiftingDao)
    var runningViewModel = RunningViewModel(runningDao)
    var swimmingViewModel = SwimmingViewModel()
    var selectedSpinnerIndex = 0
    var _currentDate : String? = ""



    var currentDate: String?
        get() {
            return _currentDate
        }
        set(value) {
            _currentDate = value
        }

    var _input1: String? = ""
    var _input2: String? = ""
    var _input3: String? = ""

    var input1: String?
        get() {
            return _input1
        }
        set(value) {
            _input1 = value
        }

    var input2: String?
        get() {
            return _input2
        }
        set(value) {
            _input2 = value
        }

    var input3: String?
        get() {
            return _input3
        }
        set(value) {
            _input3 = value
        }
    fun onAddButtonClick(view : View){
        print("Add Button Clicked")
        if (selectedSpinnerIndex == 0){

            weightLiftingViewModel.insert(view,currentDate!!,input1!!, input2!!, input3!!);
        }
        if(selectedSpinnerIndex == 1){

            runningViewModel.insert(view,currentDate!!,input1!!,input2!!)

        }
    }

    fun onDeleteButtonClick(){
        print("Delete button clicked")
        runningViewModel.select()
    }




}


//package org.rohan.patel.finalprojectandroid.viewModels
//
//import android.app.Application
//import android.content.Context
//import android.util.Log
//import android.widget.EditText
//import android.widget.Toast
//import androidx.lifecycle.ViewModel
//import kotlinx.android.synthetic.main.fragment_log_exercise.view.*
//import org.rohan.patel.finalprojectandroid.Dao.RunningDao
//import org.rohan.patel.finalprojectandroid.Dao.SwimmingDao
//import org.rohan.patel.finalprojectandroid.Dao.WeightLiftingDao
//import org.rohan.patel.finalprojectandroid.Entity.WeightLiftingEntity
//import org.rohan.patel.finalprojectandroid.R
//import org.rohan.patel.roomdatabasesample.FitDatabase
//import kotlin.math.log
//
//class AddLogViewModel(val weightLiftingDao: WeightLiftingDao,val runningDao: RunningDao, val swimmingDao: SwimmingDao,application: Application) : ViewModel() {
//    var weightLiftingViewModel = WeightLiftingViewModel(weightLiftingDao)
//    var runningViewModel = RunningViewModel(runningDao)
//    var swimmingViewModel = SwimmingViewModel()
//    var selectedSpinnerIndex = 0
//
//    var _input1: String? = ""
//    var _input2: String? = ""
//    var _input3: String? = ""
//
//    var input1: String?
//    get() {
//        return _input1
//    }
//    set(value) {
//        _input1 = value
//    }
//
//    var input2: String?
//        get() {
//            return _input2
//        }
//        set(value) {
//            _input2 = value
//        }
//
//    var input3: String?
//        get() {
//            return _input3
//        }
//        set(value) {
//            _input3 = value
//        }
//    fun onAddButtonClick(){
//        print("Add Button Clicked")
//        if (selectedSpinnerIndex == 0){
//
//                weightLiftingViewModel.insert(input1!!, input2!!, input3!!);
//        }
//        if(selectedSpinnerIndex == 1){
//
//                runningViewModel.insert(input1!!,input2!!)
//
//        }
//    }
//
//    fun onDeleteButtonClick(){
//        print("Delete button clicked")
//        runningViewModel.select()
//    }
//
//
//}