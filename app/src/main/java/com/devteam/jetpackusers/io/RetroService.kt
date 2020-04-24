package com.devteam.jetpackusers.io

import com.devteam.jetpackusers.io.model.Page
import com.devteam.jetpackusers.io.model.UserDataResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit service interface, which provides the interface for various web service apis
 */
interface RetroService {

    @GET("users")
    suspend fun getUsersForPage(@Query("page") pageId: Int): Page

    @GET("users/{id}")
    suspend fun getUserDetails(@Path("id") id: Int): UserDataResponse

}