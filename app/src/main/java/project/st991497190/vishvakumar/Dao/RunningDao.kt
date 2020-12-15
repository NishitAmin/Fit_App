package project.st991497190.vishvakumar.Dao
// Rohan Patel
import project.st991497190.vishvakumar.Entity.RunningEntity


import androidx.room.*

@Dao
interface RunningDao{
    @Query("SELECT * FROM running WHERE user_id=:userId")
    fun getAll(userId:Long) : List<RunningEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (exercise: RunningEntity)

    @Query("DELETE FROM running")
    fun deleteAll()

    @Query("UPDATE running SET DATE=:date, DISTANCE=:distance, SPEED=:speed WHERE id=:id")
    fun updateRunningEntity(date:String, distance:Float, speed:Float, id:Long )

    @Query("SELECT * FROM running WHERE id=:logId")
    fun get(logId: Long) : RunningEntity

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update (exercise: RunningEntity)

    @Query("DELETE FROM running WHERE id=:logId")
    fun delete(logId : Long)
}