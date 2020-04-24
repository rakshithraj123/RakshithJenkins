package com.devteam.jetpackusers.io.model

import com.google.gson.annotations.SerializedName

data class UserDataResponse(
    @SerializedName("data")
    val data: User
)