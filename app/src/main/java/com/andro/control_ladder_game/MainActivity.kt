package com.andro.control_ladder_game

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.andro.control_ladder_game.dialogs.SetNumberDialog
import com.andro.control_ladder_game.dialogs.SetUserDataDialog
import com.andro.control_ladder_game.dialogs.TextDialog
import com.andro.control_ladder_game.ladder_library.LadderRepository
import com.andro.control_ladder_game.viewmodels.ShareViewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    val shareViewModel : ShareViewModel by viewModels()
    private var dialog : Dialog? = null

    private val ladderRepository = LadderRepository

    var dialogValue: String = ""
        get() = field
        private set(value) {
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    fun dialogDismiss(){

    }

    fun showTextDialog(title : String, content : String, okay : () -> Unit){
        val textDialog = TextDialog(
            this, title, content) {
            dialogValue = "1"
            okay()
        }

        textDialog.show()
    }

    fun showSetNumberDialog(title : String, okay : () -> Unit){
        val setNumberDialog = SetNumberDialog(this, title){
            dialogValue = "949"
            okay()
        }
        setNumberDialog.show()
    }

    fun showInputTextDialog(title : String, okay : (String) -> Unit){
        if(dialog != null){
            dialog!!.dismiss()
        }

        dialog = SetUserDataDialog(this, title, okay)
        dialog!!.setCancelable(false)
        (dialog as SetUserDataDialog).show()
    }

    fun hihi(){
        Log.i(TAG,"hihi!")
    }
}