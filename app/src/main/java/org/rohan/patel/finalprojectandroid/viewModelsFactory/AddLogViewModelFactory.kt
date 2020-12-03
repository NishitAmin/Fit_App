package org.rohan.patel.finalprojectandroid.viewModelsFactory


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.rohan.patel.finalprojectandroid.Dao.RunningDao
import org.rohan.patel.finalprojectandroid.Dao.SwimmingDao
import org.rohan.patel.finalprojectandroid.Dao.WeightLiftingDao
import org.rohan.patel.finalprojectandroid.viewModels.AddLogViewModel

/**
 * This is pretty much boiler plate code for a ViewModel Factory.
 *
 * Provides the SleepDatabaseDao and context to the ViewModel.
 */
class AddLogViewModelFactory(
    private val weightLiftingDao: WeightLiftingDao,
    private val runningDao : RunningDao,
    private val swimmingDao : SwimmingDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddLogViewModel::class.java)) {
            return AddLogViewModel(weightLiftingDao,runningDao,swimmingDao, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

