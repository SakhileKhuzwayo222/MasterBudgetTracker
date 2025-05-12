package com.example.masterbudgetapp.data.local.entity

class Achievement {
    @Entity(tableName = "achievements")
    data class Achievement(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val title: String,
        val description: String,
        val points: Int,
        val isCompleted: Boolean
    )
}