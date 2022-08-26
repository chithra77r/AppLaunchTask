package com.applaunch.weatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.applaunch.weatherapp.R
import com.applaunch.weatherapp.SharePreferenceManager
import com.applaunch.weatherapp.data.model.User
import com.applaunch.weatherapp.databinding.FragUserListBinding
import com.applaunch.weatherapp.ui.MainActivity
import com.applaunch.weatherapp.ui.adapter.UserAdapter
import com.applaunch.weatherapp.ui.adapter.UserAdapter.SwipeToDeleteCallback
import com.applaunch.weatherapp.ui.viewmodel.UserViewModel
import com.google.android.material.snackbar.Snackbar


class UserListFrag : Fragment() {
    private lateinit var userAdapter: UserAdapter
    lateinit var binding: FragUserListBinding
    lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_user_list, container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setListeners()
        initAdapter()
        initObservers()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        fetchUsers()
    }

    private fun initObservers() {
        viewModel.userLiveData.observe(requireActivity()) {
            userAdapter.setData(it)
        }
    }

    private fun fetchUsers() {
        viewModel.getAllUsers(SharePreferenceManager.getAdminId())
    }

    private fun initAdapter() {
        binding.apply {
            userAdapter = UserAdapter(requireActivity(), object : UserAdapter.ActionListener{
                override fun onItemClick() {
                    callWeatherFrag()
                }

                override fun onItemDelete(user: User) {
                    viewModel.deleteUser(user)
                }

                override fun showUndoSnackBar() {
                    showUndoSnackbar()
                }

            })
            rvUserList.layoutManager = LinearLayoutManager(requireActivity())
            rvUserList.adapter = userAdapter
            val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(userAdapter))
            itemTouchHelper.attachToRecyclerView(rvUserList)
        }
    }

    fun setListeners() {
        binding.apply {
            btPlus.setOnClickListener {
                (activity as MainActivity).callUserFormFrag(true)
            }
        }
    }

    private fun showUndoSnackbar() {
        val snackbar: Snackbar = Snackbar.make(
            binding.root, R.string.delete_msg,
            Snackbar.LENGTH_LONG
        )
        snackbar.show()
    }

    fun callWeatherFrag() {
        (activity as MainActivity).callWeatherFrag()
    }

}