package com.klloni.viewmodeldemo1

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {

    private var total = 0

    init {
        total = startingTotal
    }

    fun getValue(): Int {
        return total
    }

    fun setValue(input: Int) {
        total += input
    }

}