package com.devteam.jetpackusers.repository

import com.devteam.jetpackusers.io.RetroService
import com.devteam.jetpackusers.io.RetrofitInstance
import com.devteam.jetpackusers.io.model.Page
import com.devteam.jetpackusers.io.model.UserDataResponse

/**
 * Data Repository class is used to get the data from web service API or the Room database
 */
class DataRepository(private var retroService: RetroService) {

    // get the list of users for the given page id
    suspend fun getUserFor(pageId: Int): Page = retroService.getUsersForPage(pageId)

    // get the user details for the given user id
    suspend fun getUserDetail(userId: Int): UserDataResponse = retroService.getUserDetails(userId)
}