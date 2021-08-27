package com.adhanjadevelopers.githubusers.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adhanjadevelopers.githubusers.data.repositories.UserRepository
import com.adhanjadevelopers.githubusers.models.UsersResponse
import com.adhanjadevelopers.githubusers.utils.Resource

class MainViewModel : ViewModel() {
    private val userRepository = UserRepository()

    val usersResponse: LiveData<Resource<UsersResponse>>
        get() = userRepository._userResponse

    init {
        userRepository.getAllUsers()
    }
}