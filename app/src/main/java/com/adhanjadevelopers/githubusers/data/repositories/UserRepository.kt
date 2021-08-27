package com.adhanjadevelopers.githubusers.data.repositories

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.adhanjadevelopers.githubusers.models.UsersResponse
import com.adhanjadevelopers.githubusers.network.UsersApi
import com.adhanjadevelopers.githubusers.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    val _userResponse = MutableLiveData<Resource<UsersResponse>>()
    fun getAllUsers() {
        _userResponse.value = Resource.Loading()
        UsersApi.retrofitService.getUsers().enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                _userResponse.value = Resource.Success(response.body())
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                _userResponse.value = Resource.Failure(t.localizedMessage)

            }
        })
    }
}