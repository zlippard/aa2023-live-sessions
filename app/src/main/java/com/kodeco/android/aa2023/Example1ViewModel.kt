package com.kodeco.android.aa2023

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Example1ViewModel : ViewModel() {

    private val _counterLiveData = MutableLiveData(0)
    val counterLiveData: LiveData<Int> = _counterLiveData

    init {
        viewModelScope.launch {
            while (true) {
                delay(1_000L)

                _counterLiveData.value = _counterLiveData.value?.plus(1)
            }
        }
    }

}
