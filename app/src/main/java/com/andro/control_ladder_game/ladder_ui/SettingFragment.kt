package com.andro.control_ladder_game.ladder_ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.andro.control_ladder_game.R
import com.andro.control_ladder_game.databinding.FragmentSettingBinding
import com.andro.control_ladder_game.dialogs.TextDialog
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
        initTopLayout(binding.settingTop, getString(R.string.main_menu_setting))
        initMenuBoard()
    }

    private fun initMenuBoard(){
        MenuBoardLayout(
            layoutInflater,
            binding.menuBoard.menuBoardList,
            listOf(
                MenuDataItem(getString(R.string.setting_king))
                { setKing() },
                MenuDataItem(getString(R.string.setting_probability))
                { setProbability() },
                MenuDataItem(getString(R.string.setting_speed))
                { setSpeed() },
                MenuDataItem(getString(R.string.setting_reset))
                { reset() },
            ),
            Pair(1000, 400)
        )
    }


    //preference에서만 진행하도록 합시당.
    private fun setKing(){

    }

    private fun setProbability(){

    }

    private fun setSpeed(){

    }

    private fun reset(){
        TextDialog("Warning!","Do you want to reset?...") {
            Log.i(TAG, "Dialog Ok Clicked!")
        }.show(parentFragmentManager, "what is the tag?")
    }
}