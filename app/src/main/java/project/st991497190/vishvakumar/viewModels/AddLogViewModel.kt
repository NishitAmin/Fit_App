package project.st991497190.vishvakumar.viewModels
// Rohan Patel - 991496523
import android.app.Application
import android.view.View
import androidx.lifecycle.ViewModel
import project.st991497190.vishvakumar.Dao.RunningDao
import project.st991497190.vishvakumar.Dao.SwimmingDao
import project.st991497190.vishvakumar.Dao.WeightLiftingDao

class AddLogViewModel(val weightLiftingDao: WeightLiftingDao, val runningDao: RunningDao, val swimmingDao: SwimmingDao, application: Application) : ViewModel() {
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
//import project.st991497190.vishvakumar.Dao.RunningDao
//import project.st991497190.vishvakumar.Dao.SwimmingDao
//import project.st991497190.vishvakumar.Dao.WeightLiftingDao
//import project.st991497190.vishvakumar.Entity.WeightLiftingEntity
//import org.rohan.patel.finalprojectandroid.R
//import project.st991497190.vishvakumar.Database.FitDatabase
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