package com.example.mvvm

import android.app.Application
import androidx.annotation.NonNull
import androidx.core.graphics.scaleMatrix
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class CountNumberModel : AndroidViewModel{

     private val mScoreA : MutableLiveData<Int> = MutableLiveData()
     private val mScoreB : MutableLiveData<Int> = MutableLiveData()

    constructor(@NonNull application: Application) : super(application) {
        mScoreA.value = 0
        mScoreB.value = 0
    }

    fun increasementScoreA(score: Int){
        mScoreA.value = mScoreA.value?.plus(score)
    }
    fun decreasementScoreA(score: Int) {
        mScoreA.value = mScoreA.value?.dec()
    }
    fun increasementScoreB(score: Int){
        mScoreB.value = mScoreB.value?.plus(score)
    }
    fun decreasementScoreB(score: Int) {
        mScoreA.value = mScoreB.value?.dec()
    }

    fun getScoreA() : MutableLiveData<Int> {
        return mScoreA
    }
    fun getScoreB() : MutableLiveData<Int> {
        return mScoreB
    }


}

