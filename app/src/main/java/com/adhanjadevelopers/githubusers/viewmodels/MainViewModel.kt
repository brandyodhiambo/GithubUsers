package com.adhanjadevelopers.githubusers.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adhanjadevelopers.githubusers.data.repositories.UserRepository
import com.adhanjadevelopers.githubusers.models.UsersResponse

class MainViewModel:ViewModel() {
    private val userRepository: UserRepository = UserRepository()

    val usersResponse:LiveData<UsersResponse>
        get() = userRepository._userResponse

    init {
        userRepository.getAllUsers()
    }
}