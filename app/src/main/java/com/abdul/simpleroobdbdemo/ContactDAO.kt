package com.abdul.simpleroobdbdemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

//Step4: Create DAO Interface to perform CURD operations

@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getContact(): LiveData<List<Contact>>
}