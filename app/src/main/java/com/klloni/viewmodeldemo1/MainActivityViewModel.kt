package com.klloni.viewmodeldemo1

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private var total = 0

    fun getValue(): Int {
        return total
    }

    fun setValue(input: Int) {
        total += input
    }

}