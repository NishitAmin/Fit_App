package org.rohan.patel.finalprojectandroid.viewModelsFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.rohan.patel.finalprojectandroid.Dao.LoginDao
import org.rohan.patel.finalprojectandroid.Dao.RunningDao
import org.rohan.patel.finalprojectandroid.Dao.SwimmingDao
import org.rohan.patel.finalprojectandroid.Dao.WeightLiftingDao
import org.rohan.patel.finalprojectandroid.viewModels.AddLogViewModel
import org.rohan.patel.finalprojectandroid.viewModels.LoginViewModel

class AddLoginViewModelFactory(
    private val loginDao : LoginDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddLogViewModel::class.java)) {
            return LoginViewModel(loginDao, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

