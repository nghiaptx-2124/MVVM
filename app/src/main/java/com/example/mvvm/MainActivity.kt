 package com.example.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

 class MainActivity : AppCompatActivity(), LifecycleOwner, View.OnClickListener {
    lateinit var mCountNumberModel: CountNumberModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCountNumberModel = ViewModelProviders.of(this).get(CountNumberModel::class.java)
        registerLiveDataListenner()
        btn_minus_a.setOnClickListener(this)
        btn_minus_b.setOnClickListener(this)
        btn_plus_A.setOnClickListener(this)
        btn_plus_b.setOnClickListener(this)
        btnShareData.setOnClickListener(this)

    }


     fun registerLiveDataListenner() {
         mCountNumberModel.getScoreA().observe(this, Observer { txt_score_A.text = "$it" })
         mCountNumberModel.getScoreB().observe(this, Observer { txt_score_B.text = "$it" })

         }

     override fun onClick(v: View?) {
         when(v?.id){
             R.id.btn_plus_A -> mCountNumberModel.increasementScoreA(1)
             R.id.btn_plus_b -> mCountNumberModel.increasementScoreB(1)
             R.id.btn_minus_a -> mCountNumberModel.decreasementScoreA(1)
             R.id.btn_minus_b -> mCountNumberModel.decreasementScoreB(1)
             R.id.btnShareData -> startActivity( Intent(this,ShareDataFragment::class.java))
         }
     }

 }
