package edu.upc.dsa

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import edu.upc.dsa.R
import android.text.SpannableStringBuilder
import android.view.View
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    private var display: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        display = findViewById(R.id.textView)
        display?.setShowSoftInputOnFocus(false)
        display?.setOnClickListener(View.OnClickListener {
            if (getString(R.string.display) == display?.getText().toString()) {
                display?.setText("")
            }
        })
    }

    private fun updateText(strToAdd: String) {
        val oldString = display!!.text.toString()
        val cursorPos = display!!.selectionStart
        val leftStr = oldString.substring(0, cursorPos)
        val rightStr = oldString.substring(cursorPos)
        if (getString(R.string.display) == display!!.text.toString()) {
            display!!.setText(strToAdd)
            display!!.setSelection(cursorPos + 1)
        } else {
            display!!.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr))
            display!!.setSelection(cursorPos + 1)
        }
    }

    fun ceroBTN(view: View?) {
        updateText("0")
    }

    fun unoBTN(view: View?) {
        updateText("1")
    }

    fun dosBTN(view: View?) {
        updateText("2")
    }

    fun tresBTN(view: View?) {
        updateText("3")
    }

    fun cuatroBTN(view: View?) {
        updateText("4")
    }

    fun cincoBTN(view: View?) {
        updateText("5")
    }

    fun seisBTN(view: View?) {
        updateText("6")
    }

    fun sieteBTN(view: View?) {
        updateText("7")
    }

    fun ochoBTN(view: View?) {
        updateText("8")
    }

    fun nueveBTN(view: View?) {
        updateText("9")
    }

    fun sumaBTN(view: View?) {
        updateText("+")
    }

    fun restaBTN(view: View?) {
        updateText("-")
    }

    fun multiplicacionBTN(view: View?) {
        updateText("×")
    }

    fun divisionBTN(view: View?) {
        updateText("÷")
    }

    fun clearBTN(view: View?) {
        display!!.setText("")
    }

    fun backBTN(view: View?) {
        val cursorPos = display!!.selectionStart
        val textLen = display!!.text.length
        if (cursorPos != 0 && textLen != 0) {
            val selection = display!!.text as SpannableStringBuilder
            selection.replace(cursorPos - 1, cursorPos, "")
            display!!.text = selection
            display!!.setSelection(cursorPos - 1)
        }
    }

    fun igualBTN(view: View?) {
        var userExp = display!!.text.toString()
        userExp = userExp.replace("÷".toRegex(), "/")
        userExp = userExp.replace("×".toRegex(), "*")
        val exp = Expression(userExp)
        val result = exp.calculate().toString()
        display!!.setText(result)
        display!!.setSelection(result.length)
    }
}