package com.example.measuredistance.viewmodel

import com.example.measuredistance.repository.UserDataFetchRepository
import com.example.measuredistance.utils.FilteredData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

/**
 * Created by Manasa on 04,June,2021
 */


class DistanceViewModelTest {

    private val repository = mockk<UserDataFetchRepository>()
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


}

