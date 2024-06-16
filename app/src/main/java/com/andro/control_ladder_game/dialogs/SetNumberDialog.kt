package com.andro.control_ladder_game.dialogs

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.andro.control_ladder_game.LadderApp
import com.andro.control_ladder_game.databinding.LayoutSetNumberContentBinding
import com.andro.control_ladder_game.ladder_library.USER_MAX_LIMIT
import com.andro.control_ladder_game.ladder_library.USER_MIN_LIMIT
import com.andro.control_ladder_game.layouts.DialogLayout
import com.andro.control_ladder_game.layouts.MenuDataItem
import com.andro.control_ladder_game.layouts.UserNumberLayout

private const val TAG = "SetNumberDialog"
class SetNumberDialog(
    context : Context,
    private val _title : String,
    private val okClick : () ->Unit,
) : DialogLayout(context,_title){
    private var number = 0

    override fun initContent() {

        binding.btnOk.setOnClickListener {
            LadderApp.instance.prefs.boomerKing = number
            okClick()
            dialogDismiss()

        }
        binding.dialogContent.addView(makeContent())
    }

    private fun makeContent() : View {
        val setNumber = LayoutSetNumberContentBinding.inflate(layoutInflater)

        setNumber.apply {
            UserNumberLayout(
                layoutInflater,
                userNumberLayout.menuBoardList,
                makeMenuList(),
                Pair(300,300),
                LinearLayout.HORIZONTAL
            )
        }

        return setNumber.root
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