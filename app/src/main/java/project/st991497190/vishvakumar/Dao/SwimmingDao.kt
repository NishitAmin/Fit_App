package project.st991497190.vishvakumar.Dao


import androidx.room.*
import project.st991497190.vishvakumar.Entity.SwimmingEntity

@Dao
interface SwimmingDao{
    @Query("SELECT * FROM weightlifting")
    fun getAll() : List<SwimmingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (exercise: SwimmingEntity)

    @Query("SELECT * FROM swimming WHERE id=:logId")
    fun get(logId: Long) : SwimmingEntity

}