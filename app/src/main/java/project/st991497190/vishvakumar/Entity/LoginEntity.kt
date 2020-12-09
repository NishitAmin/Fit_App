package project.st991497190.vishvakumar.Entity

import android.provider.ContactsContract
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.PasswordAuthentication


@Entity(tableName = "Login")
class LoginEntity (

    @PrimaryKey(autoGenerate = true)
    var id : Long,

    @ColumnInfo(name = "name")
    var name : String,

    @ColumnInfo(name = "email")
    var email : String,

    @ColumnInfo(name="password")
    var password : String,
        )