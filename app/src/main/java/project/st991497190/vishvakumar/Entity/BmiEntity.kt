package project.st991497190.vishvakumar.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
// Vishvakumar Mavani
@Entity(tableName= "bmi")
data class BmiEntity (

    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "weight")
    var weight: Int,

    @ColumnInfo(name = "height")
    var height: Int,

    @ColumnInfo(name = "value")
    var value: Int

)