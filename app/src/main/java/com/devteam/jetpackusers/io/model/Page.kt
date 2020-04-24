package com.devteam.jetpackusers.io.model


import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("data")
    val data: List<User>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)