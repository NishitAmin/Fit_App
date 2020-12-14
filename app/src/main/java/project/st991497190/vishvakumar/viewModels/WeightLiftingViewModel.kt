package project.st991497190.vishvakumar.viewModels
// Rohan Patel - 991496523
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import project.st991497190.vishvakumar.Dao.WeightLiftingDao
import project.st991497190.vishvakumar.Entity.WeightLiftingEntity
import project.st991497190.vishvakumar.UserObject

class WeightLiftingViewModel(val weightLiftingDao: WeightLiftingDao) : ViewModel() {
    fun insert(view: View, date:String, reps:String, sets:String, weight:String){
        if(reps!!.isEmpty() || sets!!.isEmpty() || weight!!.isEmpty()){
            Toast.makeText(view.context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }else {
            val newExercise = WeightLiftingEntity(
                0, UserObject.user.id,date,
                reps.toString().toInt(), sets.toString().toInt(),
                weight.toString().toInt()
            )
            doAsync {
                weightLiftingDao.insert(newExercise)
                Log.d("INSERT", "insert: Inserted weightlifting exercise")
                uiThread {
                    Toast.makeText(view.context, "Log inserted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun update(view: View, id:Long, date:String, reps:String, sets:String, weight:String){
        if(reps!!.isEmpty() || sets!!.isEmpty() || weight!!.isEmpty()){
            Toast.makeText(view.context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }else {
            val newExercise = WeightLiftingEntity(
                id, UserObject.user.id,date,
                reps.toString().toInt(), sets.toString().toInt(),
                weight.toString().toInt()
            )
            doAsync {
                weightLiftingDao.update(newExercise)
                Log.d("UPDATE", "update: Updated weightlifting exercise")
                uiThread {
                    Toast.makeText(view.context, "Log Updated", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun select(){
        doAsync {
            val logs = weightLiftingDao.getAll(UserObject.user.id)
            Log.d("SIZE", "SIZE IS "+logs.size)

        }
    }

    fun delete(logId:Long){
        doAsync {
            weightLiftingDao.delete(logId)
        }
    }
}



//package org.rohan.patel.finalprojectandroid.viewModels
//
//import android.util.Log
//import android.widget.EditText
//import androidx.databinding.ObservableInt
//import androidx.lifecycle.ViewModel
//import org.jetbrains.anko.doAsync
//import org.jetbrains.anko.uiThread
//import project.st991497190.vishvakumar.Dao.WeightLiftingDao
//import project.st991497190.vishvakumar.Entity.WeightLiftingEntity
//import org.rohan.patel.finalprojectandroid.R
//
//class WeightLiftingViewModel(val weightLiftingDao: WeightLiftingDao) : ViewModel() {
//    fun insert(reps:String, sets:String, weight:String){
//        if(reps!!.isEmpty() || sets!!.isEmpty() || weight!!.isEmpty()){
//            Log.d("EMPTY", "onAddButtonClick: FIELDS CANNOT BE EMPTY")
//        }else {
//            Log.d("INSERT", "Value inserted")
//            val newExercise = WeightLiftingEntity(
//                0, "",
//                reps.toString().toInt(), sets.toString().toInt(),
//                weight.toString().toInt()
//            )
//            doAsync {
//                weightLiftingDao.insert(newExercise)
//                Log.d("INSERT", "insert: Inserted weightlifting exercise")
//            }
//        }
//    }
//
//    fun select(){
//        doAsync {
//            val logs = weightLiftingDao.getAll()
//            Log.d("SIZE", "SIZE IS "+logs.size)
//
//        }
//    }
//}