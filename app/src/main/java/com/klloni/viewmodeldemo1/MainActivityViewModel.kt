package com.klloni.viewmodeldemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val _count = MutableLiveData<Int>()

    init {
        _count.value = 0
    }

    val count: LiveData<Int>
        get() = _count


    fun getUpdatedCount() {
        _count.value = _count.value?.plus(1)
    }
}