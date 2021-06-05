package com.example.measuredistance.viewmodel

import com.example.measuredistance.repository.UserDataFetchRepository
import com.example.measuredistance.utils.FilteredData
import com.google.gson.Gson
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test

/**
 * Created by Manasa on 04,June,2021
 */


class DistanceViewModelTest {

    private val repository = mockk<UserDataFetchRepository>(relaxed = true)
    private val okHttpClient = mockk<OkHttpClient>()
    private val viewModel: DistanceViewModel = DistanceViewModel(repository)

    @ExperimentalCoroutinesApi
    @Before
    fun initiate() {
        viewModel.setDispatcher(TestCoroutineDispatcher())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test if customer data is filtered`() = runBlockingTest {

        val stateList = mutableListOf<List<FilteredData>>()
        val job = launch {
            viewModel.getUserDataFlow().toList(stateList)
        }
        coEvery {
            repository.fetchfromNetwork()
        } returns customerDataList

        viewModel.filterData()

        val stateAfterFetchCall = stateList.last()

        assert(stateAfterFetchCall == filteredData)
        job.cancel()

    }

    @Test
    fun `test if the given response string is parsed right`(){

        val getCustomerDataFromResponseMethod = repository.javaClass.getDeclaredMethod(
            "getCustomerDataFromResponse",
          String::class.java
        )

        getCustomerDataFromResponseMethod.isAccessible = true

        val result = getCustomerDataFromResponseMethod.invoke(UserDataFetchRepository(okHttpClient,Gson()), dummyData)

        assert(result == customerDataList )
    }


}

