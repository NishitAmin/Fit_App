package org.rohan.patel.finalprojectandroid.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "jumping")
data class SwimmingEntity (
    @ColumnInfo(name = "id")
    var id : Int
)
