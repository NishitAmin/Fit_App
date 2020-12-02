package org.rohan.patel.finalprojectandroid.Dao

import org.rohan.patel.finalprojectandroid.Entity.RunningEntity


import androidx.room.*
import java.util.*

@Dao
interface RunningDao{
    @Query("SELECT * FROM running")
    fun getAll() : List<RunningEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (student:RunningEntity)

    @Query("DELETE FROM running")
    fun deleteAll()

    @Query("UPDATE FROM running SET DATE=:date, DISTANCE=:distance, SPEED=:speed WHERE id=:id")
    fun updateRunningEntity(date:String, distance:Float, speed:Float, id:Long )
}