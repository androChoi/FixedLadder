package com.andro.control_ladder_game.dialogs

import android.content.Context
import android.view.View
import com.andro.control_ladder_game.databinding.LayoutAddUserDataBinding
import com.andro.control_ladder_game.layouts.DialogLayout


class SetUserDataDialog(
    context: Context,
    private val _title: String,
    private val okClick: (String) -> Unit,
) : DialogLayout(context,_title){
    private var userName = ""
    override fun makeContent() : View {
        val addUser = LayoutAddUserDataBinding.inflate(layoutInflater)
        return addUser.root
    }

    override fun clickOk() {
        okClick(userName)
        dialogDismiss()
    }
}