package org.rohan.patel.finalprojectandroid.viewModels

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.rohan.patel.finalprojectandroid.Dao.RunningDao
import org.rohan.patel.finalprojectandroid.Dao.SwimmingDao
import org.rohan.patel.finalprojectandroid.Dao.WeightLiftingDao

class ViewLogsViewModel(val weightLiftingDao: WeightLiftingDao, val runningDao: RunningDao, val swimmingDao: SwimmingDao,
                        application: Application) : ViewModel() {

}