package com.devteam.jetpackusers.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import com.devteam.jetpackusers.repository.DataRepository
import com.devteam.jetpackusers.ui.userdetail.UserDetailViewModel
import com.devteam.jetpackusers.ui.userlist.UserListViewModel

class AppViewModelFactory(private val dataRepo: DataRepository) : Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListViewModel::class.java)) {
            return UserListViewModel(dataRepo) as T
        } else if (modelClass.isAssignableFrom(UserDetailViewModel::class.java)) {
            return UserDetailViewModel(dataRepo) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}