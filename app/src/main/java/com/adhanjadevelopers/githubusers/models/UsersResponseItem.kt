package com.adhanjadevelopers.githubusers.models


import com.google.gson.annotations.SerializedName

data class UsersResponseItem(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String
)