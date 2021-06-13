package com.example.runmanager.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Runs(
    @PrimaryKey val id: Int,

    val code : String
)
