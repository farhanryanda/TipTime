package com.farhanryanda.tiptime

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var result = 0.0

    fun calculate(tip: String,percen: String) {
        result = (tip.toDouble() * percen.toDouble())
    }
}