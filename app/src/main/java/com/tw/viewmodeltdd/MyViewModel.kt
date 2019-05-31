package com.tw.viewmodeltdd

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel(private val router: Router) : ViewModel() {

    companion object {
        private const val counterLimit = 10
    }

    private var counter: Int = 0
    val resultText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun count() {
        if (hasReachedCounterLimit()) {
            router.navigateToResultActivity()
        } else {
            counter = counter.plus(1)
            resultText.value = "Button is clicked $counter times"
        }
    }

    private fun hasReachedCounterLimit(): Boolean {
        return counter == counterLimit
    }
}
