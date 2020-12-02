package org.rohan.patel.roomdatabasesample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.rohan.patel.finalprojectandroid.Dao.RunningDao
import org.rohan.patel.finalprojectandroid.Entity.RunningEntity

@Database(entities = [RunningEntity::class],version = 1)
abstract class FitDatabase : RoomDatabase(){
    abstract fun runningDao():RunningDao

    companion object{
        @Volatile
        private var INSTANCE : org.rohan.patel.roomdatabasesample.FitDatabase? = null

        fun getInstance(context: Context) : FitDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    FitDatabase::class.java,
                    "students.db"
                ).build()
            }
            return INSTANCE as FitDatabase
        }
    }
}