package com.example.measuredistance.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.measuredistance.repository.UserDataFetchRepository
import com.example.measuredistance.viewmodel.DistanceViewModel

/**
 * Created by Manasa on 02,June,2021
 */
class DistanceViewModelFactory(
    private val customerRepository: UserDataFetchRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DistanceViewModel(customerRepository) as T
    }
}