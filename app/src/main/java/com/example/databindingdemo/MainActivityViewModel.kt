package com.example.databindingdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    // name - private, immutable
    private val _name = MutableLiveData<String>()
    val name : LiveData<String> get() = _name
    // age
    private val _age = MutableLiveData<Int>()
    val age: LiveData<Int> get() = _age

    // updating values
    fun updateName(name:String) {
        _name.value = name
    }

    fun updateAge(age:Int) {
        _age.value = age
    }
}