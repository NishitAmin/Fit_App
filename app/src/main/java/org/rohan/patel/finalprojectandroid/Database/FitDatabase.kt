package org.rohan.patel.roomdatabasesample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.rohan.patel.finalprojectandroid.Dao.LoginDao
import org.rohan.patel.finalprojectandroid.Dao.RunningDao
import org.rohan.patel.finalprojectandroid.Dao.SwimmingDao
import org.rohan.patel.finalprojectandroid.Dao.WeightLiftingDao
import org.rohan.patel.finalprojectandroid.Entity.LoginEntity
import org.rohan.patel.finalprojectandroid.Entity.RunningEntity
import org.rohan.patel.finalprojectandroid.Entity.SwimmingEntity
import org.rohan.patel.finalprojectandroid.Entity.WeightLiftingEntity

@Database(entities = [RunningEntity::class,WeightLiftingEntity::class,SwimmingEntity::class,LoginEntity::class],version = 1, exportSchema = false)
abstract class FitDatabase : RoomDatabase(){
    abstract fun runningDao():RunningDao
    abstract fun weightLiftingDao():WeightLiftingDao
    abstract fun swimmingDao():SwimmingDao
    abstract fun loginDao():LoginDao

    companion object{
        @Volatile
        private var INSTANCE : FitDatabase? = null

        fun getInstance(context: Context) : FitDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    FitDatabase::class.java,
                    "fitappdatabase"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return INSTANCE as FitDatabase
        }
    }
}