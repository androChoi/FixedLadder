package com.andro.control_ladder_game.dialogs

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.andro.control_ladder_game.LadderApp
import com.andro.control_ladder_game.databinding.LayoutSetButtonNumberBinding
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
    private var number = LadderApp.instance.prefs.gameSpeed

    override fun initContent() {
        binding.btnOk.setOnClickListener {
            LadderApp.instance.prefs.gameSpeed = number
            okClick()
            dialogDismiss()

        }
        binding.dialogContent.addView(makeContent())
    }

    private fun makeContent() : View {
        val setNumber = LayoutSetButtonNumberBinding.inflate(layoutInflater)

        setNumber.apply {
            content = number.toString()
            minusBtn.setOnClickListener {
                if(number > 1)
                    number--

                content = number.toString()
            }
            plusBtn.setOnClickListener {
                if(number < 6)
                    number ++
                content = number.toString()
            }
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