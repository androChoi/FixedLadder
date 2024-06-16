package com.andro.control_ladder_game.layouts

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.andro.control_ladder_game.databinding.LayoutMenuBoardItemBinding
import com.andro.control_ladder_game.databinding.LayoutUserNumberItemBinding

private const val TAG = "UserNumberLayout"

/**
 * @param layoutInflater Just view Layout inflater
 * @param menuBoardList Just LinearLayout, but think about scroll orientation.
 * @param list MenuDataItem
 * @param size width, height
 * @param orientation
 *
 * list를 userNumberLayout 형태로 menuBoardList에 추가한다.
 * */
class UserNumberLayout(
    private val layoutInflater : LayoutInflater,
    private val menuBoardList : LinearLayout,
    private val list : List<MenuDataItem>,
    private val size : Pair<Int,Int>,
    private val orientation: Int = LinearLayout.VERTICAL,
){
    private lateinit var menuListItem : List<View>

    fun getMenuListItem() = menuListItem
    init{
        makeMenuList()
    }

    private fun makeMenuList(){
        menuBoardList.orientation = orientation
        menuListItem = makeMenuItemList(list)
        menuListItem.forEachIndexed {index, view ->
            menuBoardList.addView(view)
            view.setOnClickListener { list[index].onClick() }
            Log.i(TAG, "makeMenuList : ${list[index].content}")
        }
    }

    private fun makeMenuItemList(list : List<MenuDataItem>) = list.map{
        val item = LayoutUserNumberItemBinding.inflate(layoutInflater)
        item.layout.layoutParams = ViewGroup.LayoutParams(size.first, size.second)
        Log.i(TAG,"size : ${item.layout.width}, ${item.layout.height}")
        item.content= it.content
        item.root
    }
}