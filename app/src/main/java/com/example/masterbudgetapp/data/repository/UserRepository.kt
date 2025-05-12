package com.example.masterbudgetapp.data.repository

import com.example.masterbudgetapp.data.local.dao.UserDao
import com.example.masterbudgetapp.data.model.User
import com.example.masterbudgetapp.data.remote.UserRemoteSource

class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val userRemote: UserRemoteSource
) {
    suspend fun getUser(): User? = userDao.getUser()
    suspend fun updateUser(user: User) {
        userDao.saveUser(user)
        userRemote.updateUserProfile(user)
    }

    fun registerUser(
        string: String,
        string: kotlin.String,
        string: kotlin.String) {}
}