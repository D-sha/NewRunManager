package com.example.runmanager.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.runmanager.dao.JobDao
import com.example.runmanager.dao.RunDao

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Runs::class, Jobs::class), version = 1, exportSchema = false)
public abstract class Db : RoomDatabase() {

    abstract fun runDao(): RunDao
    abstract fun jobDao(): JobDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: Db? = null

        fun getDatabase(context: Context): Db {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Db::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
