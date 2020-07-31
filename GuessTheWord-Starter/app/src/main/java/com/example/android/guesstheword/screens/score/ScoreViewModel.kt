package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    // The final score
    val score = finalScore
    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
    }
}