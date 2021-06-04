package com.example.measuredistance.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.measuredistance.R
import com.example.measuredistance.utils.FilteredData

/**
 * Created by Manasa on 04,June,2021
 */
class FilterAdapter(private var oldData: List<FilteredData>) :
    RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.customer_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = oldData[position]
        holder.userID.text = data.userID.toString()
        holder.userName.text = data.userName
    }

    fun submitList(itemsList: List<FilteredData>) {
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return oldData.size
            }

            override fun getNewListSize(): Int {
                return itemsList.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldData[oldItemPosition].userID == itemsList[newItemPosition].userID
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldData[oldItemPosition] == itemsList[newItemPosition]
            }

        }).dispatchUpdatesTo(this)
        oldData = itemsList
    }

    override fun getItemCount(): Int {
        return oldData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userID: TextView = itemView.findViewById(R.id.userID)
        val userName: TextView = itemView.findViewById(R.id.userName)

    }
}