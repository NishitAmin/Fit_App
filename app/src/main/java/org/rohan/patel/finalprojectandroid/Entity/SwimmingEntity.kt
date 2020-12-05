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

    @ColumnInfo(name = "reps")
    var reps : Float,

    @ColumnInfo(name="sets")
    var sets : Int,

    @ColumnInfo(name = "weight")
    var weight : String,
//
//    @ColumnInfo(name = "speed")
//    var speed : Float,

//    @ColumnInfo(name="kicks")
//    var kicks : Int,
//
//    @ColumnInfo(name = "time")
//    var time : String
)
