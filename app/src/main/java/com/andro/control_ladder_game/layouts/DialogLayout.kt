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
    protected lateinit var binding: DialogBaseLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDialog()

        binding = DialogBaseLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initDialog(){
        val displayMetrics = context.resources.displayMetrics
        val dialogWidth = (300 * displayMetrics.density).toInt() // 300dp를 px로 변환
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

            initContent()
        }
    }

    protected fun dialogDismiss(){
        this.dismiss()
    }

    abstract fun initContent()
}