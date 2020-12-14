package project.st991497190.vishvakumar.viewModels
// Rohan Patel - 991496523
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import project.st991497190.vishvakumar.Dao.SwimmingDao
import project.st991497190.vishvakumar.Entity.RunningEntity
import project.st991497190.vishvakumar.Entity.SwimmingEntity

class SwimmingViewModel(val swimmingDao: SwimmingDao) : ViewModel() {

    fun insert(view: View, date:String, speed:String, kicks:String, time:String){
        Log.d("INSERT", "TRYING TO ADD SWIMMING LOG")
        if(kicks!!.isEmpty() || speed!!.isEmpty() || time.isEmpty()){
            Toast.makeText(view.context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }else{
            doAsync {
                val newExercise = SwimmingEntity(0,date,speed.toFloat(),kicks.toInt(),time.toFloat())
                Log.d("INSERT", ""+newExercise)
                swimmingDao.insert(newExercise)
                uiThread {
                    Log.d("INSERT", "INSERT DONE")
                    Toast.makeText(view.context, "Log inserted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun update(view: View, id:Long,date:String, speed:String, kicks:String, time:String){
        if(kicks!!.isEmpty() || speed!!.isEmpty() || time.isEmpty()){
            Toast.makeText(view.context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }else {
            val newExercise = SwimmingEntity(
                id, date,
                speed.toFloat(), kicks.toInt(),time.toFloat()
            )
            doAsync {
                swimmingDao.update(newExercise)
                Log.d("UPDATE", "update: Updated running exercise")
                uiThread {
                    Toast.makeText(view.context, "Log Updated", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}