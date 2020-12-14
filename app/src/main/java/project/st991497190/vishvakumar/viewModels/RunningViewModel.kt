package project.st991497190.vishvakumar.viewModels
// Rohan Patel - 991496523
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import project.st991497190.vishvakumar.Dao.RunningDao
import project.st991497190.vishvakumar.Entity.RunningEntity
import project.st991497190.vishvakumar.Entity.WeightLiftingEntity
import project.st991497190.vishvakumar.UserObject

class RunningViewModel(val runningDao: RunningDao) : ViewModel() {
    fun insert(view: View, date:String, distance:String, speed:String){
        if(distance!!.isEmpty() || speed!!.isEmpty()){
            Toast.makeText(view.context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }else{
            doAsync {
                val newExercise = RunningEntity(0,UserObject.user.id,date,distance.toFloat(),speed.toFloat())
                runningDao.insert(newExercise)
                uiThread {
                    Toast.makeText(view.context, "Log inserted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun update(view: View, id:Long, date:String, distance:String, speed:String){
        if(distance!!.isEmpty() || speed!!.isEmpty()){
            Toast.makeText(view.context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }else {
            val newExercise = RunningEntity(
                id,UserObject.user.id, date,
                distance.toFloat(), speed.toFloat()
            )
            doAsync {
                runningDao.update(newExercise)
                Log.d("UPDATE", "update: Updated running exercise")
                uiThread {
                    Toast.makeText(view.context, "Log Updated", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun select(){
        doAsync {
            val logs = runningDao.getAll(UserObject.user.id)
            Log.d("SIZE", "select: Size of running logs is "+ logs.size)
        }
    }
}


//package org.rohan.patel.finalprojectandroid.viewModels
//
//import android.util.Log
//import androidx.lifecycle.ViewModel
//import org.jetbrains.anko.doAsync
//import project.st991497190.vishvakumar.Dao.RunningDao
//import project.st991497190.vishvakumar.Entity.RunningEntity
//import kotlin.math.log
//
//class RunningViewModel(val runningDao: RunningDao) : ViewModel() {
//    fun insert(distance:String,speed:String){
//        if(distance!!.isEmpty() || speed!!.isEmpty()){
//            Log.d("EMPTY", "onAddButtonClick: FIELDS CANNOT BE EMPTY")
//        }else{
//            doAsync {
//                val newExercise = RunningEntity(0,"",distance.toFloat(),speed.toFloat())
//                runningDao.insert(newExercise)
//                Log.d("INSERT", "insert: Inserted running exercise")
//            }
//        }
//    }
//
//    fun select(){
//        doAsync {
//            val logs = runningDao.getAll()
//            Log.d("SIZE", "select: Size of running logs is "+ logs.size)
//        }
//    }
//}