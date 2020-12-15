package project.st991497190.vishvakumar.Dao
// Vishvakumar Mavani
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import project.st991497190.vishvakumar.Entity.BmiEntity

@Dao
interface BmiDao{
    @Query("SELECT * FROM bmi")
    fun getAll(): List<BmiEntity>

    @Query("DELETE FROM bmi")
    fun deleteAllBmi()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bmi: BmiEntity)
}