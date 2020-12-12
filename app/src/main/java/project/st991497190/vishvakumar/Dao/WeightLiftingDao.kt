package project.st991497190.vishvakumar.Dao


import androidx.room.*
import project.st991497190.vishvakumar.Entity.WeightLiftingEntity

@Dao
interface WeightLiftingDao{
    @Query("SELECT * FROM weightlifting")
    fun getAll() : List<WeightLiftingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (exercise: WeightLiftingEntity)

    @Query("DELETE FROM weightlifting WHERE id=:logId")
    fun delete(logId : Long)

    @Query("SELECT * FROM weightlifting WHERE id=:logId")
    fun get(logId: Long) : WeightLiftingEntity

}