package ai.atick.databinding

import ai.atick.databinding.databinding.ActivityMainBinding
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Atick Faisal")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.editNicknameLayout.setEndIconOnClickListener { view ->
            binding.apply {
                editNicknameLayout.visibility = View.GONE
                myName?.nickname = editNickname.text.toString()
                invalidateAll()
                textNickname.visibility = View.VISIBLE
                hideKeyboard(view)
            }
        }

        binding.textNickname.setOnClickListener { view ->
            binding.apply {
                view.visibility = View.GONE
                editNicknameLayout.visibility = View.VISIBLE
                editNickname.requestFocus()
                showKeyboard(editNickname)
            }
        }
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun showKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(view, 0)
    }
}
