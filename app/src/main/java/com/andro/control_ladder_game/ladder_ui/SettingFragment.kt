package com.andro.control_ladder_game.ladder_ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.andro.control_ladder_game.R
import com.andro.control_ladder_game.databinding.FragmentSettingBinding
import com.andro.control_ladder_game.layouts.MenuBoardLayout
import com.andro.control_ladder_game.layouts.MenuDataItem

private const val TAG = "SettingFragment"
class SettingFragment : BaseFragment() {
    private lateinit var binding : FragmentSettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_setting,container,false)

        activity.hihi()
        initView()
        return binding.root
    }

    private fun initView(){
//        initTopLayout(binding.settingTop)
        initMenuBoard()
    }

    private fun initMenuBoard(){
        binding.menuBoard.scrollList.isHorizontalScrollBarEnabled = true
        SettingFragmentDirections.actionSettingToProbability(0)
        MenuBoardLayout(
            layoutInflater,
            binding.menuBoard.menuBoardList,
            listOf(
                MenuDataItem(getString(R.string.setting_king))
                { findNavController().navigate(SettingFragmentDirections.actionSettingToProbability(0)) },
                MenuDataItem(getString(R.string.setting_probability))
                { findNavController().navigate(SettingFragmentDirections.actionSettingToProbability(1)) },
                MenuDataItem(getString(R.string.setting_speed))
                { setSpeed() },
                MenuDataItem(getString(R.string.setting_reset))
                { reset() },
            ),
            Pair(1000, 400)
        )
    }

    private fun setSpeed(){
        activity.showSetNumberDialog("Set Game Speed!"){
            Log.i(TAG, "set Number Show Dialog!")
        }
    }

    private fun reset(){
        activity.showTextDialog("Warning!","Do you want to reset?..."){
            Log.i(TAG,"text dialog okay!")
        }
    }
}