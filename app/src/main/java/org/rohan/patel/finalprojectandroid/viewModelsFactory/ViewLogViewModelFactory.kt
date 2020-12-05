package org.rohan.patel.finalprojectandroid.viewModelsFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.rohan.patel.finalprojectandroid.Dao.RunningDao
import org.rohan.patel.finalprojectandroid.Dao.SwimmingDao
import org.rohan.patel.finalprojectandroid.Dao.WeightLiftingDao
import org.rohan.patel.finalprojectandroid.viewModels.AddLogViewModel
import org.rohan.patel.finalprojectandroid.viewModels.ViewLogsViewModel

class ViewLogViewModelFactory (
    private val weightLiftingDao: WeightLiftingDao,
    private val runningDao : RunningDao,
    private val swimmingDao : SwimmingDao,
    private val application: Application) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ViewLogsViewModel::class.java)) {
                return ViewLogsViewModel(weightLiftingDao,runningDao,swimmingDao, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}