package org.rohan.patel.finalprojectandroid.Dao


import androidx.room.*
import org.rohan.patel.finalprojectandroid.Entity.SwimmingEntity
import org.rohan.patel.finalprojectandroid.Entity.WeightLiftingEntity
import java.util.*

@Dao
interface SwimmingDao{
    @Query("SELECT * FROM weightlifting")
    fun getAll() : List<SwimmingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (exercise:SwimmingEntity)

}