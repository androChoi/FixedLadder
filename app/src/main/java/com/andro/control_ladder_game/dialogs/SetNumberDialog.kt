package com.andro.control_ladder_game.dialogs

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.andro.control_ladder_game.LadderApp
import com.andro.control_ladder_game.databinding.LayoutSetNumberContentBinding
import com.andro.control_ladder_game.databinding.LayoutTextContentBinding
import com.andro.control_ladder_game.layouts.DialogLayout
import com.andro.control_ladder_game.viewmodels.ShareViewModel
import java.lang.Exception

private const val TAG = "SetNumberDialog"
class SetNumberDialog(
private val _title : String,
private val okClick : () ->Unit,
) : DialogLayout(_title){
    private var number = LadderApp.instance.prefs.boomerKing
    override fun initContent() {
        binding.btnOk.setOnClickListener {
            okClick()
            LadderApp.instance.prefs.boomerKing = number
            try {
                dialog?.dismiss()
            }catch (e : Exception){
                Log.i(TAG, "Dialog null ... ??")
            }
        }
        binding.dialogContent.addView(makeContent())
    }

    private fun makeContent() : View {
        val setNumber = LayoutSetNumberContentBinding.inflate(layoutInflater)

        setNumber.apply {

        }

        return setNumber.root
    }

    private fun setNumberOnButton(){

    }
}