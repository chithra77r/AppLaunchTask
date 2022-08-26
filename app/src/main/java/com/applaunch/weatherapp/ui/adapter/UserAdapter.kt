package com.applaunch.weatherapp.ui.adapter

import android.R
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.applaunch.weatherapp.data.model.User
import com.applaunch.weatherapp.databinding.SingleRowBinding
import com.google.android.material.snackbar.Snackbar


class UserAdapter(val activity: Activity, val actionListener: ActionListener) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var recentlyDeletedItemPosition: Int = -1
    private lateinit var recentlyDeletedItem: User
    var userList = mutableListOf<User>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapter.MyViewHolder {
        val binding = DataBindingUtil.inflate<SingleRowBinding>(
            LayoutInflater.from(parent.context),
            com.applaunch.weatherapp.R.layout.single_row,
            parent,
            false
        );
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(userList: MutableList<User>){
        this.userList = userList
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        recentlyDeletedItem = userList.get(position)
        recentlyDeletedItemPosition = position
        userList.removeAt(position)
        actionListener.onItemDelete(recentlyDeletedItem)
        notifyItemRemoved(position)
        actionListener.showUndoSnackBar()
    }

    inner class MyViewHolder(val binding: SingleRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.user = userList.get(adapterPosition)

            binding.root.setOnClickListener {
                actionListener.onItemClick()
            }
        }
    }

    interface ActionListener {
        fun onItemClick()
        fun onItemDelete(user: User)
        fun showUndoSnackBar()
    }

     class SwipeToDeleteCallback(val userAdapter: UserAdapter) : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
         override fun onMove(
             recyclerView: RecyclerView,
             viewHolder: RecyclerView.ViewHolder,
             target: RecyclerView.ViewHolder
         ): Boolean {
             return true
         }

         override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
             val position = viewHolder.adapterPosition
             userAdapter.deleteItem(position)
         }
     }

}

