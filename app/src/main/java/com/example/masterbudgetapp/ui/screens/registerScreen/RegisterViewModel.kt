package com.example.masterbudgetapp.ui.screens.registerScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masterbudgetapp.data.repository.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    val registerState = MutableLiveData<Result<Boolean>>() // or use StateFlow

    fun registerUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                registerState.value = Result.Loading
                val result = userRepository.registerUser(name, email, password)
                registerState.value = Result.Success(result)
            } catch (e: Exception) {
                registerState.value = Result.Error(e)
            }
        }
    }
}