package com.example.masterbudgetapp.data.repository

class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val userRemote: UserRemoteSource
) {
    suspend fun getUser(): User? = userDao.getUser()
    suspend fun updateUser(user: User) {
        userDao.saveUser(user)
        userRemote.updateUserProfile(user)
    }
}