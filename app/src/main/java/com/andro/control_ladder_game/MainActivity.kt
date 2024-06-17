package com.andro.control_ladder_game

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.andro.control_ladder_game.dialogs.SetNumberDialog
import com.andro.control_ladder_game.dialogs.TextDialog
import com.andro.control_ladder_game.ladder_library.LadderRepository
import com.andro.control_ladder_game.viewmodels.ShareViewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    val shareViewModel : ShareViewModel by viewModels()

    private val ladderRepository = LadderRepository
    private lateinit var textDialog : TextDialog
    private lateinit var setNumberDialog : SetNumberDialog

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
        textDialog = TextDialog(
            this, title, content) {
            dialogValue = "1"
            okay()
        }

        textDialog.show()
    }

    fun showSetNumberDialog(title : String, okay : () -> Unit){
        setNumberDialog = SetNumberDialog(this, title){
            dialogValue = "949"
            okay()
        }
        setNumberDialog.show()
    }

    fun hihi(){
        Log.i(TAG,"hihi!")
    }
}