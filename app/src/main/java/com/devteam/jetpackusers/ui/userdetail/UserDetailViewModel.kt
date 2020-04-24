package com.devteam.jetpackusers.ui.userdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.devteam.jetpackusers.repository.DataRepository
import com.devteam.jetpackusers.utils.Logger
import kotlinx.coroutines.Dispatchers

/**
 * View Model class corresponding to User list fragment
 */
class UserDetailViewModel(private val dataRepository: DataRepository) : ViewModel() {

    // user id which is used to fetch the user details
    var userId = 0

    // get the user details for the given user id
    // this uses a live data scope with suspended data repository method
    val userDetails = liveData(Dispatchers.IO) {
        Logger.logThreadDetails("View Model")
        try {
            val userDataResponse = dataRepository.getUserDetail(userId.toInt())
            Logger.d("**** ViewModel - received the user details response - $userDataResponse")
            emit(userDataResponse.data)
        } catch (e: Exception) {
            emit(null)
        }
    }
}