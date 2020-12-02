package org.rohan.patel.finalprojectandroid.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running")
data class RunningEntity (
    @PrimaryKey(autoGenerate = true)
    var id : Long,

    @ColumnInfo(name  = "date")
    var date : String,

    @ColumnInfo(name = "distance")
    var distance : Float,

    @ColumnInfo(name="speed")
    var speed : Float,

)