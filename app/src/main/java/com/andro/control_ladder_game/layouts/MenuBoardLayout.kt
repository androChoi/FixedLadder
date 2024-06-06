package com.andro.control_ladder_game.layouts

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.andro.control_ladder_game.databinding.LayoutMenuBoardItemBinding

private const val TAG = "MenuBoardFragment"
class MenuBoardLayout(
    private val layoutInflater : LayoutInflater,
    private val menuBoardList : LinearLayout,
    private val list : List<MenuDataItem>,
    private val size : Pair<Int,Int>
) {
    private lateinit var menuListItem : List<View>

    fun getMenuListItem() = menuListItem
    init{
        makeMenuList()
    }

    private fun makeMenuList(){
        menuListItem = makeMenuItemList(list)
        menuListItem.forEachIndexed {index, view ->
            menuBoardList.addView(view)
            view.setOnClickListener { list[index].onClick() }
            Log.i(TAG, "makeMenuList : ${list[index].content}")
        }
    }

    private fun makeMenuItemList(list : List<MenuDataItem>) = list.map{
        val item = LayoutMenuBoardItemBinding.inflate(layoutInflater)
        item.layout.layoutParams = ViewGroup.LayoutParams(size.first, size.second)
        Log.i(TAG,"size : ${item.layout.width}, ${item.layout.height}")
        item.content= it.content
        item.root
    }
}

data class MenuDataItem(val content : String, val onClick : () -> Unit)