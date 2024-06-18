package com.andro.control_ladder_game.ladder_ui

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.andro.control_ladder_game.databinding.FragmentProbabilityBinding
import com.andro.control_ladder_game.ladder_library.USER_MAX_LIMIT
import com.andro.control_ladder_game.ladder_library.USER_MIN_LIMIT
import com.andro.control_ladder_game.layouts.MenuDataItem
import com.andro.control_ladder_game.layouts.UserNumberLayout
import com.andro.control_ladder_game.recycler_adapters.ProbabilityAdapter
import com.andro.control_ladder_game.recycler_adapters.ProbabilityItem
import com.andro.control_ladder_game.viewmodels.SetViewModel


private const val TAG = "ProbabilityFragment"
class ProbabilityFragment : BaseFragment() {
    private lateinit var binding : FragmentProbabilityBinding
    private val args : ProbabilityFragmentArgs by navArgs()
    private val setViewModel : SetViewModel by viewModels()

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
//        initTopLayout(binding.probabilityTop)
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

        binding.probabilityMainBoard.apply {
            adapter =  ProbabilityAdapter(arrayListOf(
                ProbabilityItem("1","1.1",true),
                ProbabilityItem("2","2.1",true),
                ProbabilityItem("3","3.1",false),
                ProbabilityItem("4","4.1",true),
                ProbabilityItem("5","5.1",false),
            ))

            addItemDecoration(object : RecyclerView.ItemDecoration() {
                private val spacing = 16 // Spacing in pixels

                override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                    with(outRect) {
                        top = spacing
                        bottom = spacing
                    }
                }
            })
        }
    }

    private fun makeMenuList() : List<MenuDataItem>{
        val list = arrayListOf<MenuDataItem>()
        for(i in USER_MIN_LIMIT .. USER_MAX_LIMIT){
            list.add(
                MenuDataItem(
                    "${i}명",
                ){
                    setViewModel.loadProbabilityList(i)
                }
            )
        }
        return list
    }
}