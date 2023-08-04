package com.klloni.twowaydatabindingdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

val userName = MutableLiveData<String>()
    init {
        userName.value = "klloni"
    }
    val userNameData: LiveData<String>
        get() = userName
}