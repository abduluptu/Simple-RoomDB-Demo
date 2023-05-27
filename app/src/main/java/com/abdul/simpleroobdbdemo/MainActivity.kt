package com.abdul.simpleroobdbdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize database
        database = ContactDatabase.getDatabase(this)

        // Insert Contact Record into  Database
        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0, "Abdul", "9719600615", Date(), 1))
        }
    }

    fun getData(view: View) {
        // we need to observe this getContact() because It returns LiveData
        database.contactDao().getContact().observe(this, Observer {
            Log.d("ContactList", it.toString())
        })
    }
}