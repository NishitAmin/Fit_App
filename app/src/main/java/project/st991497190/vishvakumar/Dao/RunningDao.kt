package project.st991497190.vishvakumar.Dao

import project.st991497190.vishvakumar.Entity.RunningEntity


import androidx.room.*

@Dao
interface RunningDao{
    @Query("SELECT * FROM running")
    fun getAll() : List<RunningEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (student: RunningEntity)

    @Query("DELETE FROM running")
    fun deleteAll()

    @Query("UPDATE running SET DATE=:date, DISTANCE=:distance, SPEED=:speed WHERE id=:id")
    fun updateRunningEntity(date:String, distance:Float, speed:Float, id:Long )

    @Query("SELECT * FROM running WHERE id=:logId")
    fun get(logId: Long) : RunningEntity
}