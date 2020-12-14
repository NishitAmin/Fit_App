package project.st991497190.vishvakumar.Dao


import androidx.room.*
import project.st991497190.vishvakumar.Entity.LoginEntity
import project.st991497190.vishvakumar.Entity.WeightLiftingEntity
import project.st991497190.vishvakumar.UserObject

@Dao
interface WeightLiftingDao{
    private val useObj: LoginEntity
        get() = UserObject.user

    @Query("SELECT * FROM weightlifting WHERE user_id=:userId")
    fun getAll(userId:Long) : List<WeightLiftingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (exercise: WeightLiftingEntity)

    @Query("DELETE FROM weightlifting WHERE id=:logId")
    fun delete(logId : Long)

    @Query("SELECT * FROM weightlifting WHERE id=:logId")
    fun get(logId: Long) : WeightLiftingEntity

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(exercise: WeightLiftingEntity)

}