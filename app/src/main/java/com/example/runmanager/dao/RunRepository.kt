package com.example.runmanager.dao

import com.example.runmanager.data.Run
import kotlinx.coroutines.flow.Flow

class RunRepository(private val runDao: RunDao) {
    val allRuns: Flow<List<Run>> = runDao.getAll()

}