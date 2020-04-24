package com.devteam.jetpackusers.ui.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.devteam.jetpackusers.repository.DataRepository
import com.devteam.jetpackusers.utils.Logger
import kotlinx.coroutines.Dispatchers

/**
 * View Model class corresponding to User list fragment
 */
class UserListViewModel(private val dataRepository: DataRepository) : ViewModel() {

    // page number which is used to get the list of users
    private var pageNo = 1

    // get the list of users for the given page id.
    // this uses a live data scope with suspended data repository method
    val users = liveData(Dispatchers.IO) {
        Logger.logThreadDetails("View Model")
        try {
            Logger.d("**** ViewModel BEFORE ")
            val page = dataRepository.getUserFor(pageNo)
            Logger.d("**** ViewModel AFTER - received the page response - $page")
            emit(page.data)
        } catch (e: Exception) {
            Logger.d("**** Exception $e")
            emit(listOf())
        }
    }
}