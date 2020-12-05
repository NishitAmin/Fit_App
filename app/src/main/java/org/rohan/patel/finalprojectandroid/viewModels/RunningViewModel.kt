package org.rohan.patel.finalprojectandroid.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import org.jetbrains.anko.doAsync
import org.rohan.patel.finalprojectandroid.Dao.RunningDao
import org.rohan.patel.finalprojectandroid.Entity.RunningEntity
import kotlin.math.log

class RunningViewModel(val runningDao: RunningDao) : ViewModel() {
    fun insert(distance:String,speed:String){
        if(distance!!.isEmpty() || speed!!.isEmpty()){
            Log.d("EMPTY", "onAddButtonClick: FIELDS CANNOT BE EMPTY")
        }else{
            doAsync {
                val newExercise = RunningEntity(0,"",distance.toFloat(),speed.toFloat())
                runningDao.insert(newExercise)
                Log.d("INSERT", "insert: Inserted running exercise")
            }
        }
    }

    fun select(){
        doAsync {
            val logs = runningDao.getAll()
            Log.d("SIZE", "select: Size of running logs is "+ logs.size)
        }
    }
}