package org.rohan.patel.finalprojectandroid.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.rohan.patel.finalprojectandroid.Entity.BmiEntity

@Dao
interface BmiDao{
    @Query("SELECT * FROM bmi")
    fun getAll(): List<BmiEntity>

    @Query("DELETE FROM bmi")
    fun deleteAllBmi()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bmi: BmiEntity)
}