package org.rohan.patel.roomdatabasesample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.rohan.patel.finalprojectandroid.Dao.RunningDao
import org.rohan.patel.finalprojectandroid.Dao.SwimmingDao
import org.rohan.patel.finalprojectandroid.Dao.WeightLiftingDao
import org.rohan.patel.finalprojectandroid.Entity.RunningEntity
import org.rohan.patel.finalprojectandroid.Entity.SwimmingEntity
import org.rohan.patel.finalprojectandroid.Entity.WeightLiftingEntity

@Database(entities = [RunningEntity::class,WeightLiftingEntity::class,SwimmingEntity::class],version = 1)
abstract class FitDatabase : RoomDatabase(){
    abstract fun runningDao():RunningDao
    abstract fun weightLiftingDao():WeightLiftingDao
    abstract fun swimmingDao():SwimmingDao

    companion object{
        @Volatile
        private var INSTANCE : FitDatabase? = null

        fun getInstance(context: Context) : FitDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    FitDatabase::class.java,
                    "fitapp"
                ).build()
            }
            return INSTANCE as FitDatabase
        }
    }
}