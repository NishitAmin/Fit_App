package project.st991497190.vishvakumar.Dao


import androidx.room.*
import project.st991497190.vishvakumar.Entity.SwimmingEntity
import project.st991497190.vishvakumar.Entity.WeightLiftingEntity

@Dao
interface SwimmingDao{
    @Query("SELECT * FROM swimming WHERE user_id=:userId")
    fun getAll(userId:Long) : List<SwimmingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (exercise: SwimmingEntity)

    @Query("SELECT * FROM swimming WHERE id=:logId")
    fun get(logId: Long) : SwimmingEntity

    @Query("DELETE FROM swimming WHERE id=:logId")
    fun delete(logId : Long)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(exercise: SwimmingEntity)


}