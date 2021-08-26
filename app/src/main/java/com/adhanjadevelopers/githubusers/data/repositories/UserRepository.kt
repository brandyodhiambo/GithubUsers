package com.adhanjadevelopers.githubusers.data.repositories

import androidx.lifecycle.MutableLiveData
import com.adhanjadevelopers.githubusers.models.UsersResponse
import com.adhanjadevelopers.githubusers.network.UsersApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    val _userResponse=MutableLiveData<UsersResponse>()
    fun getAllUsers(){
        UsersApi.retrofitService.getUsers().enqueue(object :Callback<UsersResponse>{
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                _userResponse.value=response.body()
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {

            }
        })
    }
}