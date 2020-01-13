package com.example.mvvm.master

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class MasterViewModel(@NonNull application: Application) : AndroidViewModel(application) {
    private val dsData : MutableLiveData<List<String>> = MutableLiveData()
    private val dsSelectedItem : MutableLiveData<String> = MutableLiveData()

    init {
        dsData.value = getSample()
    }

    fun getSample() : List<String> = listOf("Mcmillian","AA","BB","VV","XX","WW","QQ")

    fun getData() : MutableLiveData<List<String>> = dsData

    fun getSelectItem() : MutableLiveData<String> = dsSelectedItem

    fun setSelectedItem(item : String) {
        dsSelectedItem.value = item
    }

}