package project.st991497190.vishvakumar.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import project.st991497190.vishvakumar.Dao.RunningDao
import project.st991497190.vishvakumar.Dao.SwimmingDao
import project.st991497190.vishvakumar.Dao.WeightLiftingDao

class ViewLogsViewModel(val weightLiftingDao: WeightLiftingDao, val runningDao: RunningDao, val swimmingDao: SwimmingDao,
                        application: Application) : ViewModel() {

}