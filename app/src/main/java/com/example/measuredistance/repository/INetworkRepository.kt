package com.example.measuredistance.repository

import com.example.measuredistance.model.CustomerData

/**
 * Created by Manasa on 02,June,2021
 */
interface INetworkRepository {
    fun fetchfromNetwork(): List<CustomerData>
}