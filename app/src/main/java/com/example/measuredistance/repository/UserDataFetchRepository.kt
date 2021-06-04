package com.example.measuredistance.repository

import androidx.annotation.VisibleForTesting
import com.example.measuredistance.model.CustomerData
import com.example.measuredistance.utils.Constants
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by Manasa on 02,June,2021
 */
class UserDataFetchRepository(private val okHttpClient: OkHttpClient, private val gson: Gson) :
    INetworkRepository {

    override fun fetchfromNetwork(): List<CustomerData> {

        var customerDataFromResponse = listOf<CustomerData>()
        val request = Request.Builder()
            .url(Constants.REQUEST_URL)
            .build()
        try {
            val response = this.okHttpClient.newCall(request).execute()
            val body = response.body
            val responseString = body?.string()
            customerDataFromResponse = getCustomerDataFromResponse(responseString)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return (customerDataFromResponse)
    }

    private fun getCustomerDataFromResponse(responseString: String?): List<CustomerData> {
        val customerDataList = arrayListOf<CustomerData>()
        val responseList = responseString?.split("\n")
        responseList?.forEach {
            val customerData = this.gson.fromJson(it, CustomerData::class.java)
            customerDataList.add(customerData)
        }
        return customerDataList.toList()
    }

}