package project.st991497190.vishvakumar.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import project.st991497190.vishvakumar.Entity.LoginEntity

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun userRegistration (login: LoginEntity)

    @Query("SELECT * FROM login WHERE email=:email AND password=:password")
    fun checkUser (email: String, password: String) : Boolean

}