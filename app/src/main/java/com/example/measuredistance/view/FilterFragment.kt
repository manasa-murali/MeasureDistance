package com.example.measuredistance.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.measuredistance.R
import com.example.measuredistance.repository.UserDataFetchRepository
import com.example.measuredistance.utils.DistanceViewModelFactory
import com.example.measuredistance.viewmodel.DistanceViewModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient

class FilterFragment : Fragment(R.layout.fragment_filter) {

    private val viewModel: DistanceViewModel by viewModels {
        DistanceViewModelFactory(UserDataFetchRepository(OkHttpClient(), Gson()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.filterList)
        recyclerView.layoutManager = LinearLayoutManager(context)

        var adapter = recyclerView.adapter
        if (adapter == null) {
            adapter = FilterAdapter(emptyList())
            recyclerView.adapter = adapter
        }
        viewModel.filterData()

        lifecycleScope.launch {
            viewModel.getUserDataFlow().collect {
                (adapter as FilterAdapter).submitList(it)
            }
        }
    }
}