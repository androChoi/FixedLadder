package com.andro.control_ladder_game.ladder_ui

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.andro.control_ladder_game.MainActivity
import com.andro.control_ladder_game.R
import com.andro.control_ladder_game.databinding.LayoutMenuBoardBinding
import com.andro.control_ladder_game.databinding.LayoutMenuTopBinding
import com.andro.control_ladder_game.viewmodels.ShareViewModel

open class BaseFragment : Fragment() {
    protected val shareViewModel : ShareViewModel by  activityViewModels()
    protected val activity: MainActivity by lazy { requireActivity() as MainActivity }




    protected fun initTopLayout(topLayout: LayoutMenuTopBinding, title: String){
        topLayout.backButton.setOnClickListener { findNavController().popBackStack() }
        topLayout.title = title
    }
}