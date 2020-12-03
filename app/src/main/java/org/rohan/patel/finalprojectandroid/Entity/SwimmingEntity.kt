package org.rohan.patel.finalprojectandroid.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "swimming")
data class SwimmingEntity (
    @PrimaryKey(autoGenerate = true)
    var id : Long,

    @ColumnInfo (name  = "date")
    var date : String,

    @ColumnInfo(name = "speed")
    var reps : Float,

    @ColumnInfo(name="kicks")
    var sets : Int,

    @ColumnInfo(name = "time")
    var weight : Float
)
