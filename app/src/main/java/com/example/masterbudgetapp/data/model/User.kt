package com.example.masterbudgetapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey private val id: Int,
    val name: String,
    val email: String,
    val password : String,
    val createdAt: Long)

)