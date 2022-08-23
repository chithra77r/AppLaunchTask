package com.applaunch.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.applaunch.weatherapp.R
import com.applaunch.weatherapp.data.model.User
import com.applaunch.weatherapp.databinding.SingleRowBinding

class UserListAdapter(val userList: List<User>) :
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserListAdapter.MyViewHolder {
        val binding = DataBindingUtil.inflate<SingleRowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.single_row,
            parent,
            false
        );
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UserListAdapter.MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class MyViewHolder(val binding: SingleRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.user = userList.get(adapterPosition)
        }
    }

}