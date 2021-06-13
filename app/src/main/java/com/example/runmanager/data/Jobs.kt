package com.example.runmanager.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Jobs(
    @PrimaryKey val id: Int,

    val customerID: Int
)
