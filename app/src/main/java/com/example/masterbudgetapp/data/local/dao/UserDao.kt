package com.example.masterbudgetapp.data.local.dao

import androidx.room.*
import com.example.masterbudgetapp.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user LIMIT 1")
    suspend fun getUser(): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: User)
}