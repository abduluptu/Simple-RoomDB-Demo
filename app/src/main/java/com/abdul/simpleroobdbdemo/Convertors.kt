package com.abdul.simpleroobdbdemo

import androidx.room.TypeConverter
import java.util.Date

//Step6: Convert values vice versa

class Convertors {

    @TypeConverter
    fun fromDateToLong(value: Date): Long{
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value: Long): Date{
        return Date(value)
    }
}