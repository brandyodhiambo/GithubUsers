package com.adhanjadevelopers.githubusers.network

import com.adhanjadevelopers.githubusers.models.UsersResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Call<UsersResponse>
}