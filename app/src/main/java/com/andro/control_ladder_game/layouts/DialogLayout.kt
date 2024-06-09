package com.andro.control_ladder_game.layouts

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.andro.control_ladder_game.databinding.DialogBaseLayoutBinding

abstract class DialogLayout(private val _title : String) : DialogFragment() {
    protected lateinit var binding: DialogBaseLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogBaseLayoutBinding.inflate(inflater, container, false)



        initView()

        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener {
            val displayMetrics = resources.displayMetrics
            val dialogWidth = (300 * displayMetrics.density).toInt() // 300dp를 px로 변환
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setLayout(dialogWidth, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.setCancelable(false)
        }
        return dialog
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

    abstract fun initContent()
}