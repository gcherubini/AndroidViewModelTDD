package com.tw.viewmodeltdd

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    val resultText: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    private var counter: Int = 0

    fun count() {
        counter = counter.plus(1)
        resultText.value = "Button is clicked $counter times"
    }
}
