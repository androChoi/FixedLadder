package com.andro.control_ladder_game.ladder_ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.andro.control_ladder_game.MainActivity
import com.andro.control_ladder_game.R
import com.andro.control_ladder_game.databinding.FragmentProbabilityBinding
import com.andro.control_ladder_game.databinding.FragmentSettingBinding
import com.andro.control_ladder_game.ladder_library.USER_MAX_LIMIT
import com.andro.control_ladder_game.ladder_library.USER_MIN_LIMIT
import com.andro.control_ladder_game.layouts.MenuDataItem
import com.andro.control_ladder_game.layouts.UserNumberLayout
import com.andro.control_ladder_game.recycler_adapters.ProbabilityAdapter
import com.andro.control_ladder_game.recycler_adapters.ProbabilityItem
import com.andro.control_ladder_game.viewmodels.ShareViewModel


private const val TAG = "ProbabilityFragment"
class ProbabilityFragment : BaseFragment() {
    private lateinit var binding : FragmentProbabilityBinding
    private val args : ProbabilityFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProbabilityBinding.inflate(inflater, container, false)
        initView(args.mode)
        return binding.root
    }

    private fun initView(mode : Int){
        initTopLayout(binding.probabilityTop, if(mode == 0) "확률 조정" else "당첨 확정 번호 선택")
        initMidLayout(mode)
    }

    private fun initMidLayout(mode : Int){
        UserNumberLayout(
            layoutInflater,
            binding.userNumberBoard.menuBoardList,
            makeMenuList(),
            Pair(300,200),
            LinearLayout.HORIZONTAL
        )

        binding.probabilityMainBoard.adapter = ProbabilityAdapter(arrayOf(
            ProbabilityItem("1","1.1",true),
            ProbabilityItem("2","2.1",true),
            ProbabilityItem("3","3.1",false),
            ProbabilityItem("4","4.1",true),
            ProbabilityItem("5","5.1",false),
        ))
    }

    private fun makeMenuList() : List<MenuDataItem>{
        val list = arrayListOf<MenuDataItem>()
        for(i in USER_MIN_LIMIT .. USER_MAX_LIMIT){
            list.add(
                MenuDataItem(
                    "${i}명",
                ){
                    Log.i(TAG, "${i} clicked!!")
                }
            )
        }
        return list
    }
}