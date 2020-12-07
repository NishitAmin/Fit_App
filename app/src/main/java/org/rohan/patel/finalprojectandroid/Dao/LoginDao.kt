package org.rohan.patel.finalprojectandroid.Dao

import android.database.Cursor
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.jetbrains.annotations.NotNull
import org.rohan.patel.finalprojectandroid.Entity.LoginEntity

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun userRegistration (login:LoginEntity)

    @Query("SELECT * FROM login WHERE email=:email AND password=:password")
    fun checkUser (email: String, password: String) : Boolean

}