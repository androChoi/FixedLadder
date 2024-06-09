package com.andro.control_ladder_game.dialogs

import android.util.Log
import android.view.View
import com.andro.control_ladder_game.databinding.LayoutTextContentBinding
import com.andro.control_ladder_game.layouts.DialogLayout
import java.lang.Exception

private const val TAG = "TextDialog"
class TextDialog(
    private val _title : String,
    private val _content : String,
    private val okClick : () ->Unit,

) : DialogLayout(_title){
    override fun initContent() {
        binding.btnOk.setOnClickListener {
            okClick()
            try {
                dialog?.dismiss()
            }catch (e : Exception){
                Log.i(TAG, "Dialog null ... ??")
            }
        }
        binding.dialogContent.addView(makeContent())
    }

    private fun makeContent() : View {
        val text = LayoutTextContentBinding.inflate(layoutInflater)

        text.content = _content

        return text.root
    }
}