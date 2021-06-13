package com.example.runmanager.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.runmanager.data.Jobs
import com.example.runmanager.data.Job
import com.example.runmanager.data.Run

@Dao
interface JobDao {
    @Insert
    fun insertAll(vararg jobs: Jobs)

    @Query("SELECT customerID FROM Jobs")
    fun getSingle(): Job

    @Query("SELECT * FROM Runs")
    fun getAll(): List<Run>
}