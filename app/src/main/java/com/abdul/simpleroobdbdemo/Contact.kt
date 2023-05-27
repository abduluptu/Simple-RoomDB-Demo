package com.abdul.simpleroobdbdemo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.jar.Attributes.Name

//Step3: Create Table as data class

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val phone: String,
    // add new column
    val createdDate: Date,
    // add new column for migration
    val isActive: Int
)
