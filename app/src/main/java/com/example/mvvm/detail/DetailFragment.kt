package com.example.mvvm.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.master.MasterViewModel
import com.example.mvvm.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(), LifecycleOwner{
    lateinit var  mViewModel: MasterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(activity!!).get(MasterViewModel::class.java)
        mViewModel.getSelectItem().observe(this, Observer { text_user_name.text = it })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail,container,false)
    }
}