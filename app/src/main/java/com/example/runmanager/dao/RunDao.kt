package com.example.runmanager.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.runmanager.data.Run
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {
    @Insert
    fun insertAll(vararg runs: Run)

    @Query("SELECT code FROM runs")
    fun getSingle(): Run

    @Query("SELECT * FROM Runs")
    fun getAll(): Flow<List<Run>>
}