package ai.atick.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_nickname_layout.setEndIconOnClickListener { view ->
            edit_nickname_layout.visibility = View.GONE
            text_nickname.text = edit_nickname.text.toString()
            text_nickname.visibility = View.VISIBLE
            hideKeyboard(view)
        }

        text_nickname.setOnClickListener { view ->
            view.visibility = View.GONE
            edit_nickname_layout.visibility = View.VISIBLE
            edit_nickname.requestFocus()
            showKeyboard()
        }
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun showKeyboard() {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(edit_nickname, 0)
    }
}
