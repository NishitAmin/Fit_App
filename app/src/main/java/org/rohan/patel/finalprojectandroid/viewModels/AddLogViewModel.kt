package org.rohan.patel.finalprojectandroid.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import org.rohan.patel.finalprojectandroid.Dao.RunningDao
import org.rohan.patel.finalprojectandroid.Dao.SwimmingDao
import org.rohan.patel.finalprojectandroid.Dao.WeightLiftingDao
import org.rohan.patel.roomdatabasesample.FitDatabase

class AddLogViewModel(val weightLiftingDao: WeightLiftingDao,val runningDao: RunningDao, val swimmingDao: SwimmingDao,application: Application) : ViewModel() {
    var weightLiftingViewModel = WeightLiftingViewModel()
    var runningViewModel = RunningViewModel()
    var swimmingViewModel = SwimmingViewModel()
    fun onAddButtonClick(){
        print("Add Button Clicked")
    }

    fun onDeleteButtonClick(){
        print("Delete button clicked")
    }
}