package com.example.android.shoestore.pages

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel:ViewModel() {
//    var _shoe_name= MutableLiveData<String>()
//    var _company_name= MutableLiveData<String>()
//    var _size= MutableLiveData<String>()
//    var _discription= MutableLiveData<String>()

    var shoe= Shoe("","","","")

    var list = MutableLiveData<MutableList<Shoe>>()
//    private var _is_done=MutableLiveData<Boolean>()
//    val is_done :LiveData<Boolean> get() = _is_done
    init {
        list.value= mutableListOf()
    }

    fun setshoe(){
        list.value!!.add(shoe)
        shoe= Shoe("","","","")
    }
//    private fun reset()
//    {
//        shoe.value?.name=""
//        shoe.value?.company=""
//        shoe.value?.size =""
//        shoe.value?.description =""
//    }
}