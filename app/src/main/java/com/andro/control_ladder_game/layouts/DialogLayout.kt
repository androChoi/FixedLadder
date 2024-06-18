package com.andro.control_ladder_game.layouts

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.andro.control_ladder_game.MainActivity
import com.andro.control_ladder_game.databinding.DialogBaseLayoutBinding

abstract class DialogLayout(context : Context, private val _title : String) : Dialog(context) {
    private lateinit var binding: DialogBaseLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogBaseLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initDialog()
    }

    private fun initDialog(){
        val displayMetrics = context.resources.displayMetrics
        val dialogWidth = (350 * displayMetrics.density).toInt()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(dialogWidth, ViewGroup.LayoutParams.WRAP_CONTENT)
        setCancelable(false)
    }

    private fun initView(){
        binding.apply {
            title = _title

            btnCancel.setOnClickListener {
                dismiss()
            }

            btnOk.setOnClickListener {
                clickOk()
            }

            dialogContent.addView(makeContent())
        }
    }

    protected fun dialogDismiss(){
        this.dismiss()
    }
    abstract fun makeContent() : View
    abstract fun clickOk()
}