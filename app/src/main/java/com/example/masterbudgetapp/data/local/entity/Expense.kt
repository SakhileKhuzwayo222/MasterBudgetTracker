package com.example.masterbudgetapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

class Expense {
    @Entity(tableName = "expenses")
    data class Expense(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val title: String,
        val amount: Double,
        val category: String,
        val date: Long
    )
}