package com.abdul.simpleroobdbdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

//Step5: Create Database to store entities

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Convertors::class)    //Step7: Annotate with @TypeConverters
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDAO

    // create singleton object of data base
    companion object {

        //Step: implement migration
        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

        @Volatile   // If INSTANCE value update then all Threads get update about it
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDb"
                    )
                        .addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}