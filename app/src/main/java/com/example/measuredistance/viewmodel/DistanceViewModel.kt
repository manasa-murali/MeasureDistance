package com.example.measuredistance.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.measuredistance.model.CustomerData
import com.example.measuredistance.repository.UserDataFetchRepository
import com.example.measuredistance.utils.Constants
import com.example.measuredistance.utils.FilteredData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.math.*

/**
 * Created by Manasa on 02,June,2021
 */
class DistanceViewModel(
    private val customerRepository: UserDataFetchRepository
) : ViewModel() {

    private var dispatcher = Dispatchers.IO

    private val userDataFlow = MutableStateFlow<List<FilteredData>>(emptyList())

    fun getUserDataFlow() = userDataFlow.asStateFlow()


    fun filterData() {

        viewModelScope.launch(dispatcher) {

            val customerDataList = customerRepository.fetchfromNetwork()

            val filteredCustomers = customerDataList.filter {
                isUserInRange(it)
            }.sortedBy {
                it.userID
            }

            val userRenderData = getUserRenderData(filteredCustomers)

            userDataFlow.emit(userRenderData)
        }
    }


    private fun getUserRenderData(filteredCustomers: List<CustomerData>): List<FilteredData> {
        val userRenderData = ArrayList<FilteredData>()
        filteredCustomers.forEach { customerData ->
            userRenderData.add(
                FilteredData(
                    userID = customerData.userID,
                    userName = customerData.userName,
                )
            )
        }
        return userRenderData.toList()
    }

    private fun isUserInRange(customerData: CustomerData): Boolean {
        return Pair(Constants.DUBLIN_LATITUDE, Constants.DUBLIN_LONGITUDE).compute(
            customerData.latitude,
            customerData.longitude
        ) < Constants.MAX_DISTANCE
    }

    private fun Pair<Double, Double>.compute(latitude: Double, longitude: Double): Double {

        val phi1 = degreeToRadians(latitude)
        val lambda1 = degreeToRadians(longitude)

        val phi2 = degreeToRadians(this.first)
        val lambda2 = degreeToRadians(this.second)

        val deltaLamba = abs(lambda2 - lambda1)

        val deltaSigma = acos((sin(phi1) * sin(phi2)) + (cos(phi1) * cos(phi2)) * cos(deltaLamba))

        return Constants.EARTH_RADIUS * deltaSigma
    }


    private fun degreeToRadians(degree: Double): Double {
        return degree * (Math.PI / 180)
    }

    @VisibleForTesting
    fun setDispatcher(dispatcher: CoroutineDispatcher) {
        this.dispatcher = dispatcher
    }
}


