package org.rohan.patel.finalprojectandroid.Dao


import androidx.room.*
import org.rohan.patel.finalprojectandroid.Entity.WeightLiftingEntity
import java.util.*

@Dao
interface WeightLiftingDao{
    @Query("SELECT * FROM weightlifting")
    fun getAll() : List<WeightLiftingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (exercise:WeightLiftingEntity)

}