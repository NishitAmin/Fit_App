package org.rohan.patel.finalprojectandroid.viewModels

import android.util.Log
import android.widget.EditText
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.rohan.patel.finalprojectandroid.Dao.WeightLiftingDao
import org.rohan.patel.finalprojectandroid.Entity.WeightLiftingEntity
import org.rohan.patel.finalprojectandroid.R

class WeightLiftingViewModel(val weightLiftingDao: WeightLiftingDao) : ViewModel() {
    fun insert(reps:String, sets:String, weight:String){
        if(reps!!.isEmpty() || sets!!.isEmpty() || weight!!.isEmpty()){
            Log.d("EMPTY", "onAddButtonClick: FIELDS CANNOT BE EMPTY")
        }else {
            Log.d("INSERT", "Value inserted")
            val newExercise = WeightLiftingEntity(
                0, "",
                reps.toString().toInt(), sets.toString().toInt(),
                weight.toString().toInt()
            )
            doAsync {
                weightLiftingDao.insert(newExercise)
                Log.d("INSERT", "insert: Inserted weightlifting exercise")
            }
        }
    }

    fun select(){
        doAsync {
            val logs = weightLiftingDao.getAll()
            Log.d("SIZE", "SIZE IS "+logs.size)

        }
    }
}