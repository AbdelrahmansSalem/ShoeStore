package com.example.android.shoestore.pages

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel:ViewModel() {
    var _shoe_name= MutableLiveData<String>()
    var _company_name= MutableLiveData<String>()
    var _size= MutableLiveData<String>()
    var discription= MutableLiveData<String>()


    var list = mutableListOf<Shoe>()
//    private var _is_done=MutableLiveData<Boolean>()
//    val is_done :LiveData<Boolean> get() = _is_done

    fun setshoe(){
        var shoe:Shoe= Shoe(_shoe_name.value.toString(),_company_name.value.toString(),_size.value.toString(),discription.value.toString())
        list.add(shoe)
        reset()
    }

    private fun reset()
    {
        _shoe_name.value=""
        _company_name.value=""
        _size.value=""
        discription.value=""
    }
}