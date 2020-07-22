package ai.atick.colormyview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var clickCount: Int = 0
    private lateinit var cardList: List<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardList = listOf(card_1, card_2, card_3, card_4, card_5)
    }

    @Suppress("UNUSED_PARAMETER")
    fun revealCard(view: View) {
        cardList.forEachIndexed { index, v ->
            if (index == clickCount) v.visibility = View.VISIBLE
        }
        clickCount++
        if (clickCount > 5) {
            clickCount = 0
            cardList.forEach { v ->
                v.visibility = View.GONE
            }
        }
    }
}
