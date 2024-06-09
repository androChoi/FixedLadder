package com.andro.control_ladder_game.ladder_ui

import android.media.tv.TvContract
import android.media.tv.TvContract.Programs
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.andro.control_ladder_game.MainActivity
import com.andro.control_ladder_game.R
import com.andro.control_ladder_game.databinding.FragmentMenuBinding
import com.andro.control_ladder_game.layouts.MenuBoardLayout
import com.andro.control_ladder_game.layouts.MenuDataItem
import com.andro.control_ladder_game.viewmodels.ShareViewModel
import java.nio.charset.CoderResult
import java.security.CodeSource

private const val TAG = "MenuFragment"
class MenuFragment : Fragment() {
    private lateinit var binding : FragmentMenuBinding
    private val shareViewModel : ShareViewModel by  activityViewModels()
    private val activity: MainActivity by lazy { requireActivity() as MainActivity }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_menu,container,false)

        initView()

        return binding.root
    }

    private fun initView(){
        initMenuBoard()
    }


    private fun initMenuBoard(){
        MenuBoardLayout(
            layoutInflater,
            binding.menuBoard.menuBoardList,
            listOf(
                MenuDataItem(getString(R.string.main_menu_start))
                { findNavController().navigate(R.id.action_menuFragment_to_userFragment) },
                MenuDataItem(getString(R.string.main_menu_record))
                {},
                MenuDataItem(getString(R.string.main_menu_setting))
                {findNavController().navigate(R.id.action_menuFragment_to_settingFragment)},
                MenuDataItem(getString(R.string.main_menu_exit))
                {activity.finish()},
            ),
            Pair(800, 400)
        )
    }
}
