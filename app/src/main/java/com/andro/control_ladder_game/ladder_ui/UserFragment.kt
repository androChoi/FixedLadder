package com.andro.control_ladder_game.ladder_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.andro.control_ladder_game.MainActivity
import com.andro.control_ladder_game.R
import com.andro.control_ladder_game.viewmodels.ShareViewModel


private const val TAG = "UserFragment"
class UserFragment : Fragment() {
    private val shareViewModel : ShareViewModel by  activityViewModels()
    private val activity: MainActivity by lazy { requireActivity() as MainActivity }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user, container, false)
    }
}