package com.andro.control_ladder_game.ladder_ui

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.andro.control_ladder_game.R
import com.andro.control_ladder_game.databinding.FragmentUserBinding
import com.andro.control_ladder_game.databinding.LayoutSetButtonNumberBinding
import com.andro.control_ladder_game.ladder_library.USER_MAX_LIMIT
import com.andro.control_ladder_game.ladder_library.USER_MIN_LIMIT
import com.andro.control_ladder_game.layouts.LayoutSetNumber
import com.andro.control_ladder_game.recycler_adapters.ProbabilityAdapter
import com.andro.control_ladder_game.recycler_adapters.UserListAdapter
import com.andro.control_ladder_game.viewmodels.UserViewModel


private const val TAG = "UserFragment"
class UserFragment : BaseFragment() {
    private lateinit var binding : FragmentUserBinding
    private val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user, container, false)
        lateinit var layoutSetNumber : LayoutSetNumber

        val userListAdapter = UserListAdapter{idx ->
            activity.showInputTextDialog("이름을 변경하세용~",){
                userViewModel.updateTheWorldName(idx, it)

            }
        }
        binding.apply {
            initTopLayout(titleBar, "운명의 전사들")
            userListRecyclerView.adapter = userListAdapter
            setUserCount.plusBtn.setOnClickListener {
                userViewModel.createTheNewWorld()
                userListRecyclerView.scrollToPosition(userListAdapter.itemCount-1)
            }
            setUserCount.minusBtn.setOnClickListener {
                userViewModel.deleteTheNewWorld()
                userListRecyclerView.scrollToPosition(userListAdapter.itemCount-1)
            }
        }

        userViewModel.userList.observe(viewLifecycleOwner){
            userListAdapter.setUserList(it)
            binding.setUserCount.content = userViewModel.userNumber.toString()
            Log.i(TAG,it.toString())
        }

        return binding.root
    }
}